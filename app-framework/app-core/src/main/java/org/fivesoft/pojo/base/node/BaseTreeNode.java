package org.fivesoft.pojo.base.node;

import java.util.List;

/**
 * 树节点接口
 *
 * @author wenx
 * @date 2020-11-09
 */
public interface BaseTreeNode {


    /**
     * 获取节点id
     *
     * @return 节点id
     */
    Long getId();

    /**
     * 获取节点父id
     *
     * @return 节点父id
     */
    Long getPid();

    /**
     * 设置children
     *
     * @param children 子节点集合
     */
    void setChildren(List children);
}
