package cn.com.yijuan.model.student.exam;

import lombok.Data;

@Data
public class ExamPaperPageResponseVO {
    private Integer id;

    private String name;

    private Integer questionCount;

    private Integer score;

    private String createTime;

    private Integer createUser;

    private Integer subjectId;

    private String subjectName;

    private Integer paperType;

    private Integer frameTextContentId;
}
