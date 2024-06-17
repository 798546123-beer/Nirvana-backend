package com.example.demo.Entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: annal
 * \\_/__/
 * @Date: 2024/6/17
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value="analyticsreport")
public class AnalyticsReport {
    @TableId(value = "reportId")
    String reportId;
    @TableField(value = "reportType")
    String reportType;
    @TableField(value = "generatedDate")
    String generatedDate;
    @TableField(value = "keyMetrics")
    String keyMetrics;
    @TableField(value = "detailedData")
    String detailedData;
}
