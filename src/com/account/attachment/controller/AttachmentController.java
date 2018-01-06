package com.account.attachment.controller;

import com.account.attachment.service.AttachmentService;
import com.account.bean.Attachment;
import com.account.common.base.BaseController;
import com.account.common.constant.ConfigConsts;
import com.account.common.utils.DateUtil;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 附件表 功能类
 *
 * @author 董广斌
 * @date 2017/10/30
 * @time 17:09
 */
@Controller
@RequestMapping("/attachment")
public class AttachmentController extends BaseController {


    private static final Logger log = LoggerFactory.getLogger(AttachmentController.class);

    @Autowired
    private AttachmentService attachmentService;


    /**
     * 下载方式：内联inline和附件attachment(带上文件名)
     */
    private String contentDisposition;

    /**
     * 下载方式：内联inline和附件attachment
     */
    private String downloadMethod = "attachment";

    /**
     * 下载路径
     */
    private String path;



    /**
     * 保存单条附件
     *
     * @param entity   附件实体
     * @param file     上传文件
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/insertAttachment")
    public ModelAndView insertAttachment(Attachment entity, MultipartFile file,
                                         HttpServletRequest request, HttpServletResponse response) {
        ModelAndView view = new ModelAndView("callback_resume");
        try {
            String rootPath = request.getSession().getServletContext()
                    .getRealPath(ConfigConsts.ATTACHMENT_ROOT_PATH)
                    + File.separatorChar;
            Attachment attachment = attachmentService.insertAttachment(entity, getUser(), file, rootPath);
            view.addObject("code", 1);
        } catch (Exception e) {
            log.error("保存附件失败", e);
            view.addObject("code", 0);
        }
        return view;
    }

    /**
     * 保存单条附件
     *
     * @param entity   附件实体
     * @param file     上传文件
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/insertAttachments")
    public ModelAndView insertAttachments(Attachment entity, MultipartFile[] file,
                                         HttpServletRequest request, HttpServletResponse response) {
        ModelAndView view = new ModelAndView("callback_resume");
        try {
            String rootPath = request.getSession().getServletContext()
                    .getRealPath(ConfigConsts.ATTACHMENT_ROOT_PATH)
                    + File.separatorChar;
            for (MultipartFile fi:file){
                Attachment attachment = new Attachment();
                attachment.setAtLinkTable(entity.getAtLinkTable());
                attachment.setAtLinkId(entity.getAtLinkId());
                attachmentService.insertAttachment(attachment, getUser(), fi, rootPath);
            }
            view.addObject("code", 1);
        } catch (Exception e) {
            log.error("保存附件失败", e);
            view.addObject("code", 0);
        }
        return view;
    }

    /**
     * 删除单条附件
     *
     * @param entity  附件信息
     * @param request
     * @return 基础类
     */
    @ResponseBody
    @RequestMapping(value = "/deleteAttachment")
    public void deleteAttachment(Attachment entity, HttpServletRequest request) {
        try {
            String rootPath = request.getSession().getServletContext()
                    .getRealPath(ConfigConsts.ATTACHMENT_ROOT_PATH)
                    + File.separatorChar;
            attachmentService.deleteAttachment(entity, getUser(), rootPath);
        } catch (Exception e) {
            log.error("删除附件失败", e);
        }
    }

    /**
     * 删除多个附件
     *
     * @param ids     附件信息
     * @param request
     * @return 基础类
     */
    @ResponseBody
    @RequestMapping(value = "/deleteAttachments")
    public void deleteAttachments(String ids, HttpServletRequest request) {
        try {
            String rootPath = request.getSession().getServletContext()
                    .getRealPath(ConfigConsts.ATTACHMENT_ROOT_PATH)
                    + File.separatorChar;
            attachmentService.deleteAttachments(ids, getUser(), rootPath);
        } catch (Exception e) {
            log.error("删除附件失败", e);
        }
    }

    /**
     * 更新单条附件
     *
     * @param entity 附件信息
     * @return 基础类
     */
    @ResponseBody
    @RequestMapping(value = "/updateAttachment")
    public void updateAttachment(Attachment entity) {
        try {
            attachmentService.updateAttachment(entity, getUser());
        } catch (Exception e) {
            log.error("更新附件失败", e);
        }
    }

    /**
     * 单个下载附件
     *
     * @param entity
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/downloadAttachment")
    public ModelAndView downloadAttachment(Attachment entity, HttpServletRequest request,
                                           HttpServletResponse response) {
        try {
            BufferedInputStream bis = null;
            BufferedOutputStream bos = null;
            //根据主键获取附件对象
            entity = attachmentService.getAttachment(entity.getId());
            // 转换编码
            contentDisposition = downloadMethod + ";filename="
                    + java.net.URLEncoder.encode(entity.getAtName(), "UTF-8");
            String rootPath = request.getSession().getServletContext()
                    .getRealPath(ConfigConsts.ATTACHMENT_ROOT_PATH)
                    + File.separatorChar;
            path = rootPath + entity.getAtPath();
            File file = new File(path);
            if (file.exists()) {
                long fileLength = file.length();
                response.setContentType("application/octet-stream");
                response.setHeader("Content-disposition", "attachment; filename="
                        + java.net.URLEncoder.encode(entity.getAtName(), "UTF-8"));

                response.setHeader("Content-Length", String.valueOf(fileLength));
                response.setContentType(entity.getAtMimeType());

                bis = new BufferedInputStream(new FileInputStream(path));

                bos = new BufferedOutputStream(response.getOutputStream());

                byte[] buff = new byte[2048];

                int bytesRead;

                while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                    bos.write(buff, 0, bytesRead);
                }
                bos.flush();
                bis.close();
                bos.close();
            }
        } catch (UnsupportedEncodingException e) {
            log.error("文件名称转换编码失败", e);
        } catch (Exception e) {
            log.error("文件下载失败", e);
        }
        return null;
    }


    /**
     * 打包下载
     *
     * @param ids
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/zipAndDownloadAttachment")
    public ModelAndView zipAndDownloadAttachment(Integer[] ids,
                                                 HttpServletRequest request, HttpServletResponse response) throws Exception {
        ZipOutputStream zos = null;
        try {
            List<Attachment> atts = new ArrayList<Attachment>();
            for (int i = 0; i < ids.length; i++) {
                Long id = Long.valueOf(ids[i]);
                Attachment att = attachmentService.getAttachment(id);
                atts.add(att);
            }
            String fileName = DateUtil.getMillisecond() + ".zip";
            response.setContentType("application/octet-stream");
            response.setHeader("Content-disposition",
                    "attachment; filename=" + fileName);

            zos = new ZipOutputStream(response
                    .getOutputStream());

            File[] files = new File[atts.size()];
            String rootPath = request.getSession().getServletContext()
                    .getRealPath(ConfigConsts.ATTACHMENT_ROOT_PATH)
                    + File.separatorChar;
            for (int j = 0; j < files.length; j++) {
                path = rootPath + atts.get(j).getAtPath();
                files[j] = new File(path);
            }

            zipFile(files, "", zos);


        } catch (UnsupportedEncodingException e) {
            log.error("文件名称转换编码失败", e);
        } catch (Exception e) {
            log.error("文件下载失败", e);
        }finally {
            zos.flush();
            zos.close();
        }
        return null;
    }

    /**
     * 写入文件
     *
     * @param subs
     * @param baseName
     * @param zos
     * @throws IOException
     */
    private void zipFile(File[] subs, String baseName, ZipOutputStream zos)
            throws IOException {
        for (int i = 0; i < subs.length; i++) {
            File f = subs[i];
            zos.putNextEntry(new ZipEntry(baseName + f.getName()));
            FileInputStream fis = new FileInputStream(f);
            byte[] buffer = new byte[2048];
            int r = 0;
            while ((r = fis.read(buffer)) != -1) {
                zos.write(buffer, 0, r);
            }
            fis.close();
        }
    }


    public String getContentDisposition() {
        return contentDisposition;
    }

    public void setContentDisposition(String contentDisposition) {
        this.contentDisposition = contentDisposition;
    }

    public String getDownloadMethod() {
        return downloadMethod;
    }

    public void setDownloadMethod(String downloadMethod) {
        this.downloadMethod = downloadMethod;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
