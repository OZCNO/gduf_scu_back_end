package org.scu.base.domain;

import org.scu.base.vo.Pagination;

import java.util.List;

/**
 * Created by Lamm on 2018/12/19.
 */
public class PaginationResult {

  private long totalCount;

  private long page;

  private long pageSize;

  private List<?> list;

  public PaginationResult() {
  }

  public PaginationResult(List<?> list) {
    this.list = list;
    this.page = 1;
    this.pageSize = list.size();
    this.totalCount = list.size();
  }

  public PaginationResult(List<?> list, long page, long pageSize, long totalCount) {
    this.list = list;
    this.page = page;
    this.pageSize = pageSize;
    this.totalCount = totalCount;
  }

  public PaginationResult(List<?> list, Pagination pagination, long totalCount) {
    this(list, pagination.getPage(), pagination.getPageSize(), totalCount);
  }

//  public long getTotalPage() {
//    long totalPage = totalCount / getPageSize();
//    if (totalPage * getPageSize() != totalCount) {
//      totalPage++;
//    }
//    return totalPage;
//  }

  public long getTotalCount() {
    return totalCount;
  }

  public void setTotalCount(long totalCount) {
    this.totalCount = totalCount;
  }

  public long getPage() {
    return page < 1 ? 1 : page;
  }

  public void setPage(long page) {
    this.page = page;
  }

  public long getPageSize() {
    return pageSize < 1 ? 1 : pageSize;
  }

  public void setPageSize(long pageSize) {
    this.pageSize = pageSize;
  }

  public List<?> getList() {
    return list;
  }

  public void setList(List<?> list) {
    this.list = list;
  }
}
