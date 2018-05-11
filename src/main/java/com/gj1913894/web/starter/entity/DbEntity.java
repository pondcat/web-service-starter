package com.gj1913894.web.starter.entity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.Serializable;

/**
 * 数据库表对应实体类的接口
 * <div>主键:必需单主键id, 类型为bigint/varchar, 可以为自增或非自增</div>
 * <div>日期类型:推荐使用{@link java.time.LocalDateTime}, {@link java.time.LocalDate}, {@link java.time.LocalTime}, 尽量不要用{@link java.util.Date}</div>
 * <div>表必需有ctime(创建时间)字段,mtime(更新时间)根据需求决定. ctime和mtime默认不添加至实体类中,由数据库自行维护,如业务需求方可添加至实体类中,尽量由数据库自行维护</div>
 * <div>布尔类型:数据库字段类型建议为tinyint(1)</div>
 *
 * @author gejian
 */
public interface DbEntity<T extends Serializable> {
    T getId();

    void setId(T id);

    default String toJson() {
        return JSON.toJSONString(this, SerializerFeature.DisableCircularReferenceDetect);
    }
}
