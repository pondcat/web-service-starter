package com.gj1913894.web.starter.entity;

/**
 * 记录表数据的最后一次修改者, 需要记录最后一次操作者id的表, 请实现该接口.
 * 后续可能会对实现该接口的实体类做一些自动化操作, 如自动setter当前线程登陆用户id到{@link #setModifier(Long)}
 */
public interface DbModifier {

	Long getModifier();

	void setModifier(Long modifier);
}
