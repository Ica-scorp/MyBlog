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
public class CommentReply implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value="comment_reply_id")
    private String commentReplyId;

    private String commentId;

    private String replyUserId;

    private String secondlyUserId;

    private String replyContent;

    private LocalDateTime commentReplyTime;


}
