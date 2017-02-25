package com.shiro.query;

/**
 * @author zhuzhenke
 */
public class BaseQuery {
    public final static int DEFAULT_PAGE_SIZE = 100;
    public final static int DEFAULT_PAGE_NUM = 1;
    protected Integer pageSize = DEFAULT_PAGE_SIZE;
    protected Integer startRow;//起始行
    protected Integer endRow;//结束行(闭合)
    protected Integer page = DEFAULT_PAGE_NUM;

    public Integer getStartRow() {
        return startRow;
    }

    public BaseQuery setStartRow(Integer startRow) {
        this.startRow = startRow;
        return this;
    }

    public Integer getEndRow() {
        return endRow;
    }

    public BaseQuery setEndRow(Integer endRow) {
        this.endRow = endRow;
        return this;
    }

    public BaseQuery setPage(Integer page) {
        if (page < 0) page = DEFAULT_PAGE_NUM;
        this.page = page;
        this.startRow = (page - 1) * this.pageSize;
        this.endRow = this.startRow + this.pageSize - 1;
        return this;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public BaseQuery setPageSize(Integer pageSize) {
        if (pageSize < 1) pageSize = 1;
        this.pageSize = pageSize;
        this.startRow = (page - 1) * this.pageSize;
        this.endRow = this.startRow + this.pageSize - 1;
        return this;
    }

    public Integer getPage() {
        return page;
    }
}
