package com.example.blog.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2023-10-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UploadFileList implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 上传文件的列表
     */
    @TableId(value="upload_file_list_id")
    private String uploadFileListId;

    /**
     * 文件大小，作为文件唯一标识
     */
    private Long fileSize;

    /**
     * 文件路径url
     */
    private String fileUrl;

    /**
     * 文件上传时间
     */
    private LocalDateTime uploadFileTime;


}