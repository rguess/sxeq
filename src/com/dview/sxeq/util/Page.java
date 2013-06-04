package com.dview.sxeq.util;

import java.util.ArrayList;

public class Page {

	private int curPage;// 当前是第几页
	private int rowCount = 5;// 每页显示多少行
	private int maxPage; // 共有多少页
	private int rowNum;// 共有多少行信息
	private ArrayList data;// 所有信息
	private ArrayList pageData; // 当前页面显示信息

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public int getRowNum() {
		return rowNum;
	}

	public void setRowNum() {
		rowNum = data.size();
	}

	public void setMaxPage() {
		if (data.size() % rowCount == 0) {
			maxPage = data.size() / rowCount;// 如果没有余数，说明所有信息能在当前显示完
		} else {
			maxPage = data.size() / rowCount + 1;// 如果有余数，说明所有信息不能在当前显示完，所以应加上一页才可以显示所有信息

		}
	}

	public ArrayList getData() {
		return data;
	}

	public void setData(ArrayList arrayList) {
		data = arrayList;
	}

	public ArrayList getPageData() {
		return pageData;
	}

	public void setPageData() {
		pageData = new ArrayList();
		for (int i = rowCount * (curPage - 1); i < rowCount * curPage; i++) {
			if (i == data.size()) {
				break;
			}
			pageData.add(data.get(i));
		}
	}
}
