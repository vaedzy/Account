package com.account.attachment.service;

import com.account.bean.Attachment;
import com.account.bean.Person;
import org.springframework.web.multipart.MultipartFile;

/**
 * 附件表接口
 *
 * @author 董广斌
 * @date 2017/10/30
 * @time 17:10
 */
public interface AttachmentService {
    /**
     * 根据主键获取 附件对象
     *
     * @param id
     * @return
     */
    Attachment getAttachment(Long id);


    /**
     * 保存单条附件
     *
     * @param attachment 附件信息
     * @param person     上传人信息
     * @param file
     * @param rootPath
     * @return
     */
    Attachment insertAttachment(Attachment attachment, Person person, MultipartFile file, String rootPath);

    /**
     * 删除单条附件
     *
     * @param attachment 附件信息主键
     * @param person     上传人信息
     * @param rootPath
     * @return
     */
    boolean deleteAttachment(Attachment attachment, Person person, String rootPath);


    /**
     * 删除附件
     *
     * @param ids      附件信息主键
     * @param person   上传人信息
     * @param rootPath
     * @return
     */
    boolean deleteAttachments(String ids, Person person, String rootPath);

    /**
     * 更新单条附件
     *
     * @param attachment 附件信息
     * @param person     上传人信息
     * @return 基础类
     */
    Attachment updateAttachment(Attachment attachment, Person person);


}
