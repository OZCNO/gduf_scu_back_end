package org.scu.base.vo;

/**
 * Created by Lamm on 2018/12/19.
 */
public class Pagination {

  /**
   *  default page size the db query
   */
  public static final int DEFAULT_PAGE_SIZE = 10;

  private long page;

  private long pageSize = DEFAULT_PAGE_SIZE;

  public long getStartRecord() {
    return (getPage() - 1) * getPageSize();
  }

  public long getEndRecord() {
    return getPageSize();
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
}
