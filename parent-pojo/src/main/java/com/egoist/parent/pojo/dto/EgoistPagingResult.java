package com.egoist.parent.pojo.dto;

/**
 * 分页响应结果
 */
public class EgoistPagingResult extends EgoistResult {
    /**
     * 当前页码，从1开始
     */
    private Integer pageNum;
    /**
     * 总页数
     */
    private Integer totalPageNum;
    /**
     * 每页数量
     */
    private Integer pageSize;
    /**
     * 总记录数
     */
    private Long totalCount;

    /**
     * 是否有下一页
     */
    private Boolean hasNextPage;
    /**
     * 是否上一页
     */
    private Boolean hasPrePage;

    /**
     * 是否第一页
     */
    private Boolean isFirstPage;

    /**
     * 是否最后一页
     */
    private Boolean isLastPage;

    /**
     * 下一页
     */
    private Integer nextPage;

    /**
     * 上一页
     */
    private Integer prePage;

    /**
     * @return pageNum
     */
    public Integer getPageNum() {
        return pageNum;
    }

    /**
     * @param pageNum pageNum
     */
    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    /**
     * @return totalPageNum
     */
    public Integer getTotalPageNum() {
        return totalPageNum;
    }

    /**
     * @param totalPageNum totalPageNum
     */
    public void setTotalPageNum(Integer totalPageNum) {
        this.totalPageNum = totalPageNum;
    }

    /**
     * @return pageSize
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * @param pageSize pageSize
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * @return totalCount
     */
    public Long getTotalCount() {
        return totalCount;
    }

    /**
     * @param totalCount totalCount
     */
    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * @return hasNextPage
     */
    public Boolean getHasNextPage() {
        return hasNextPage;
    }

    /**
     * @param hasNextPage hasNextPage
     */
    public void setHasNextPage(Boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    /**
     * @return hasPrePage
     */
    public Boolean getHasPrePage() {
        return hasPrePage;
    }

    /**
     * @param hasPrePage hasPrePage
     */
    public void setHasPrePage(Boolean hasPrePage) {
        this.hasPrePage = hasPrePage;
    }

    /**
     * @return isFirstPage
     */
    public Boolean getFirstPage() {
        return isFirstPage;
    }

    /**
     * @param isFirstPage isFirstPage
     */
    public void setFirstPage(Boolean firstPage) {
        isFirstPage = firstPage;
    }

    /**
     * @return isLastPage
     */
    public Boolean getLastPage() {
        return isLastPage;
    }

    /**
     * @param isLastPage isLastPage
     */
    public void setLastPage(Boolean lastPage) {
        isLastPage = lastPage;
    }

    /**
     * @return nextPage
     */
    public Integer getNextPage() {
        return nextPage;
    }

    /**
     * @param nextPage nextPage
     */
    public void setNextPage(Integer nextPage) {
        this.nextPage = nextPage;
    }

    /**
     * @return prePage
     */
    public Integer getPrePage() {
        return prePage;
    }

    /**
     * @param prePage prePage
     */
    public void setPrePage(Integer prePage) {
        this.prePage = prePage;
    }
}
