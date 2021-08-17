package com.example.java.Tecent;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author dzy
 * @title GroupPlayer
 * @projectName Java
 * @description 撮合两支 10v10 的队伍
 *  名词相关： 两方阵营使用 group， 阵营内的小队使用 team
 * @date 2021/8/16 17:03
 */
public class MatchTeam {
    /**
     * 存储各小队人数的数组
     */
    List<Integer> teams;

    /**
     * 撮合后的阵营大小
     */
    final int GROUP_SIZE = 10;

    public MatchTeam(List<Integer> inputTeams) {
        teams = inputTeams;
    }

    /**
     * 获得一种撮合结果
     *
     * @return 撮合结果 格式为:
     * {
     * [1, 5, 1, 3] ,
     * [2, 6, 2] ,
     * [5, 2, 3] ,
     * [6, 4]
     * }
     * 前 n/2 成对的为匹配成功的 team 人数数组
     */
    public List<List<Integer>> matchResult() {
        // 初始化
        result = new ArrayList<>();
        hasJoined = new ArrayList<>(teams.size());
        for (int i = 0; i < teams.size(); i++) {
            hasJoined.add(Boolean.FALSE);
        }
        // dfs
        for (int i = 0; i < teams.size() ;i++) {
            if (!hasJoined.get(i)) {
                dfs(i, new ArrayList<>(), new Boolean(false));
            }
        }
        return result;
    }

    /**
     * 保存递归求解结果的数组
     */
    private List<List<Integer>> result;

    /**
     * 保存某一编号的 team 是否已经加入一个阵营
     */
    private List<Boolean> hasJoined;

    /**
     * 递归求解
     *
     * @param curIndex 当前正在尝试将哪一组 team 加入阵营
     * @param curGroup 当前正在尝试加人的阵营
     * @param isEnd 标记当前 group 是否 匹配结束
     */
    private void dfs(int curIndex, List<Integer> curGroup, Boolean isEnd) {
        // 当前 group 大小
        int curGroupSum = curGroup.stream().mapToInt(Integer::intValue).sum();
        // 已经匹配到十人
        if (curGroupSum == 10) {
            // 加入结果
            // 还没有匹配的 group 或者上一个 group 已经成对 则新建一个

            result.add(new ArrayList<>(curGroup));
            // 标记这些 team 为已经加入状态 这里可以优化查找效率
            for (Integer team: curGroup) {
                hasJoined.set(teams.indexOf(team), Boolean.TRUE);
            }
            // 当前递归已经求得解
            isEnd = Boolean.TRUE;
            return;
        } else {
            // 尝试在剩下的 team 中搜索
            for (int nextIndex = curIndex + 1; nextIndex < teams.size(); nextIndex++) {
                // 某次递归已经求得解 跳出循环
                if (isEnd) {
                    return;
                }
                // 已经加入某一 group
                if (hasJoined.get(nextIndex)) {
                    continue;
                }
                if (curGroupSum + teams.get(nextIndex) <= 10) {
                    // 尝试将这一对加入
                    curGroup.add(nextIndex);
                    dfs(nextIndex, curGroup, isEnd);
                    // 回溯
                    curGroup.remove(curGroup.size() - 1);
                }
            }
        }
    }

}
