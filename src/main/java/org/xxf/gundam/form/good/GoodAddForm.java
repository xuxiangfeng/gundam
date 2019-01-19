package org.xxf.gundam.form.good;

import lombok.Data;
import org.xxf.gundam.annotation.TrimNotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author: xxf
 * @date: 2019/1/14 0014 下午 4:05
 */
@Data
public class GoodAddForm {

    @TrimNotEmpty(message = "名称不能为空")
    private String name;

    @NotNull(message = "数量不能为空")
    @Min(value = 1, message = "必须大于0")
    private Integer num;

    @NotNull(message = "请指定数量单位")
    @Min(value = 0, message = "数量单位错误")
    @Max(value = 1, message = "数量单位错误")
    private Integer isApproximate;

    @NotNull(message = "请提供场所信息")
    @Min(value = 1, message = "请提供场所信息")
    private Integer placeId;

}
