package com.account.attachment.service.impl;


import com.account.attachment.service.AttachmentService;
import com.account.bean.Attachment;
import com.account.bean.Person;
import com.account.common.utils.ReflectUtil;
import com.account.mapper.AttachmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 附件表 实现类
 *
 * @author 董广斌
 * @date 2017/10/30
 * @time 17:34
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AttachmentServiceImpl implements AttachmentService {

    @Autowired(required = false)
    private AttachmentMapper attachmentMapper;

    /**
     * 根据主键获取 附件对象
     *
     * @param id
     * @return
     */
    @Override
    public Attachment getAttachment(Long id) {
        Attachment attachment = attachmentMapper.selectByPrimaryKey(id);
        return attachment;
    }

    /**
     * 保存单条附件
     *
     * @param attachment           附件信息
     * @param personnelInformation 上传人信息
     * @return 基础类
     */
    @Override
    public Attachment insertAttachment(Attachment attachment, Person personnelInformation, MultipartFile file, String rootPath) {
        if (file == null) {
            return null;
        }
        if (attachment.getAtLinkTable() == null
                || attachment.getAtLinkTable().trim().length() == 0
                || attachment.getAtLinkId() == null) {
            return null;
        }
        // 分文件夹保存
        rootPath += attachment.getAtLinkTable() + File.separator;
        // 创建文件夹
        if (!new File(rootPath).isDirectory()) {
            new File(rootPath).mkdirs();
        }
        // 文件后缀
        String suffix = file.getOriginalFilename().substring(
                file.getOriginalFilename().lastIndexOf("."));
        // 保存文件名前缀
        String prefix = attachment.getAtLinkTable() + "_"
                + attachment.getAtLinkId() + "_";
        // 文件保存名字 不带后缀
        String dstName = prefix
                + file.getOriginalFilename()
                .substring(0, file.getOriginalFilename().lastIndexOf("."));

        int x = 1;
        String dstNameTemp = dstName;
        while (new File(rootPath + dstName + suffix).exists()) {
            dstName = dstNameTemp + x;
            x++;
        }
        // 存文件
        try {
            file.transferTo(new File(rootPath + dstName + suffix));
        } catch (IllegalStateException e1) {
            e1.printStackTrace();
            return null;
        } catch (IOException e1) {
            e1.printStackTrace();
            return null;
        }

        attachment.setAtName(dstName.substring(prefix.length()) + suffix);
        // 设置文件类型
        attachment.setAtType(suffix);
        // 设置mime类型
        attachment.setAtMimeType(file.getContentType());
        // 设置文件路径
        attachment.setAtPath(attachment.getAtLinkTable() + File.separator
                + dstName + suffix);
        attachment = (Attachment) ReflectUtil.setDefaultAttrbute(attachment, personnelInformation);


        attachment.setAtUploadTime(new Date());

        attachmentMapper.insert(attachment);


        return attachmentMapper.selectByPrimaryKey(attachment.getId());
    }

    /**
     * 删除单条附件
     *
     * @param attachment 附件信息
     * @param person     上传人信息
     * @return 基础类
     */
    @Override
    public boolean deleteAttachment(Attachment attachment, Person person, String rootPath) {

        new File(rootPath + attachment.getAtPath()).delete();

        attachmentMapper.deleteByPrimaryKey(attachment.getId());

        return true;
    }

    /**
     * 删除附件
     *
     * @param ids      附件信息主键
     * @param person   上传人信息
     * @param rootPath
     * @return 基础类
     */
    @Override
    public boolean deleteAttachments(String ids, Person person, String rootPath) {
        //主键集合
        List<Long> idsList = new ArrayList<>();
        String[] split = ids.split(",");
        for (String id : split) {
            idsList.add(Long.valueOf(id));
        }

        List<Attachment> attachments = attachmentMapper.listAttachmentByPrimaryKeys(idsList);

        for (Attachment attachment : attachments) {
            new File(rootPath + attachment.getAtPath()).delete();
            attachmentMapper.deleteByPrimaryKey(attachment.getId());
        }
        return true;
    }

    /**
     * 更新单条附件
     * 未完成
     *
     * @param attachment 附件信息
     * @param person     上传人信息
     * @return 基础类
     */
    @Override
    public Attachment updateAttachment(Attachment attachment, Person person) {
        return null;
    }


}
