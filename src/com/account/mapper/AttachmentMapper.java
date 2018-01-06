package com.account.mapper;

import com.account.bean.Attachment;

import java.util.List;

public interface AttachmentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Attachment record);

    Attachment selectByPrimaryKey(Long id);

    List<Attachment> selectAll();

    int updateByPrimaryKey(Attachment record);

    /**
     * 根据附件主键查询多个附件信息
     *
     * @param ids
     * @return
     */
    List<Attachment> listAttachmentByPrimaryKeys(List<Long> ids);
}