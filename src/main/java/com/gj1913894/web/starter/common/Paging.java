package com.gj1913894.web.starter.common;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.pagehelper.Page;
import org.apache.commons.lang3.StringUtils;
import pondcat.commons.combine.BasePage;
import pondcat.commons.combine.constant.ConstDelimiter;

import java.util.regex.Pattern;

/**
 * @author gejian at 6/13/2018 9:31 PM
 */
public class Paging<T> extends BasePage<T> {
	private static final Pattern SORT_BY_REGEX = Pattern.compile("^\\S+$");

	private String sortBy;

	private String sortOrder;

	public Page<T> toPage(boolean count) {
		return new Page<>(getPageNumber(), getPageSize(), count);
	}

	public Paging fromPage(Page<T> page) {
		Paging<T> paging = new Paging<>();
		paging.setTotal(page.getTotal());
		paging.setContent(page.getResult());
		return paging;
	}

	/**
	 * 获取排序列
	 * @return 排序列
	 */
	@JSONField(serialize = false)
	public final String getSortBy() {
		return sortBy;
	}

	/**
	 * 设置排序列, 排序列不能含有空白字符, 如空格、制表符、换页符等
	 * @param sortBy 排序列, 不能含有空白字符, 如空格、制表符、换页符等
	 */
	public final void setSortBy(String sortBy) {
		if (StringUtils.isEmpty(sortOrder)) {
			return;
		}
		if (SORT_BY_REGEX.matcher(sortBy).matches()) {
			this.sortBy = sortBy;
		}
	}

	/**
	 * 获取排序顺序ASC或DESC
	 * @return 排序顺序: ASC, 或DESC
	 */
	@JSONField(serialize = false)
	public final String getSortOrder() {
		return sortOrder;
	}

	/**
	 * 设置排序顺序ASC或DESC
	 * @param sortOrder 以a或A开头, 排序ASC; 以d或D开头, 排序DESC
	 */
	public final void setSortOrder(String sortOrder) {
		if (StringUtils.isEmpty(sortOrder)) {
			return;
		}
		char c0 = sortOrder.charAt(0);
		if (c0 == 'a' || c0 == 'A') {
			this.sortOrder = "ASC";
		}
		else if (c0 == 'd' || c0 == 'D') {
			this.sortOrder = "DESC";
		}
	}

	/**
	 * 获取SQL排序, 如: id DESC
	 * @return 可能为null, 不会为空
	 */
	@JSONField(serialize = false)
	public final String getOrderBy() {
		if (sortBy != null) {
			if (sortOrder == null) {
				return sortBy;
			}
			return sortBy + ConstDelimiter.SPACE_CHAR + sortOrder;
		}
		return null;
	}

	@Override
	public String toString() {
		return "Paging{" +
				"sortBy='" + sortBy + '\'' +
				", sortOrder='" + sortOrder + '\'' +
				'}';
	}
}
