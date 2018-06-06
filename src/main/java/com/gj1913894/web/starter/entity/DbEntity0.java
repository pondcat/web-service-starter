package com.gj1913894.web.starter.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 数据库表对应实体类的接口, 不提供抽象类, 方便实体类可能需要继承自别的类
 *
 * <p>与{@link DbEntity}区别在于无creator(创建者)字段, 多用于用户表, 常量表, 配置表, 第三方回调记录表等不需要创建者或者无创建者的场合</p>
 *
 * <p>用户表主键必须为unsigned bigint(可自增或非自增).
 * 其他表主键:必需单主键id, 类型统一为unsigned bigint(可自增或非自增)或者char(慎用, 需指定语言为latin1, 仅允许英文数字组合).
 * 使用bigint而不是int的原因是:方便后续扩展至分布式系统后的主键生成, 性能影响不大, 硬盘便宜.
 * </p>
 *
 * <p>日期类型:推荐使用{@link java.time.LocalDateTime}, {@link java.time.LocalDate}, {@link java.time.LocalTime},
 * 尽量不要用{@link java.util.Date}</p>
 *
 * <p>实现此接口者, 必需有ctime(创建时间), 无creator(创建者主键), 而mtime(修改时间)和modifier(修改者主键)根据需求决定.
 * ctime和mtime可由数据库设默认值自行维护</p>
 *
 * <div>布尔类型:强制为tinyint(1), 不要定义为bit(1), bit(1)实际占用的也是1个字节而不是1位, 具体参考mysql官网字段类型解释</div>
 */
public interface DbEntity0<T extends Serializable> {

	T getId();

	void setId(T id);

	LocalDateTime getCtime();

	void setCtime(LocalDateTime ctime);
}
