package com.zkdn.zk.common.db.base.entity;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
* @author zhangchunhao
* @apiNote 分页对象
* @date 19:27 2021/9/14
* @param
* @return
**/
@AllArgsConstructor
@ToString
@Builder
@Getter
@Setter
public class PageInfoVO<T> implements Serializable {

    /**
     * 当前页码
     */
    private long pageNo;

    /**
     * 每页条数
     */
    private long pageSize;

    /**
     * 总条数
     */
    private long totalCount;

    /**
     * 总页数
     */
    private long totalPage;

    /**
     * 分页数据
     */
    private List<T> data;

    public PageInfoVO(IPage page){
        if(page==null) {
            //后面改成抛出异常
            return ;
        }
        this.pageNo = page.getCurrent();
        this.pageSize = page.getSize();
        this.totalCount = page.getTotal();
        this.totalPage = page.getPages();
        this.data = page.getRecords();
    }

}
