package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;


public class WarnMes implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Date occurrenceTime;            // 发生时间
    private String sessionServerIp;         // 服务器IP
    private String sessionServerPort;       // 服务器端口
    private String sessionDbInstanceName;   // 数据库实例名
    private String dbName;                  // 数据库名
    private String sessionDbEdition;        // 数据库版本
    private String appClientip;             // 客户端IP
    private String appClientport;           // 客户端端口
    private String sessionClientMac;        // 客户端MAC
    private String clientProgram;           // 客户端工具
    private String clientSystemUser;        // 客户端操作系统用户
    private String appClientUsername;       // 应用用户
    private String dbUsername;              // 数据库用户
    private String riskType;                // 风险类型
    private String riskLevel;               // 风险级别1-3
    private String level;                   // 敏感等级 1-5
    private String term;                    // 敏感术语
    private String engineAction;            // 引擎动作
    private String ruleName;                // 规则名称
    private String description;             // 规则描述
    private String operationType;           // 操作类型
    private String accessObject;            // 访问对象
    private String execCostUs;              // 响应时间
    private String resultsEnforcement;      // 执行结果
    private String affectRows;              // 影响行数
    private String sqlFullText;             // SQL语句
    private Integer state;                  // 状态0未处置1已处置
    private String branch;                  // 部门
    private String memo;                    // 备注
    private String department;              // 业务系统
    private Long idx;                       //工单id
    private Integer orderFrom;              //数据安全系统
    private Integer type;                   //数据工单
    private Integer emergencyType;          //'紧急程度'
    private Integer deptId;                 //'部门ID'

    public Integer getOrderFrom() {
        return orderFrom;
    }

    public void setOrderFrom(Integer orderFrom) {
        this.orderFrom = orderFrom;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getEmergencyType() {
        return emergencyType;
    }

    public void setEmergencyType(Integer emergencyType) {
        this.emergencyType = emergencyType;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Long getIdx() {
        return idx;
    }

    public void setIdx(Long idx) {
        this.idx = idx;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getOccurrenceTime() {
        return occurrenceTime;
    }

    public void setOccurrenceTime(Date occurrenceTime) {
        this.occurrenceTime = occurrenceTime;
    }

    public String getSessionServerIp() {
        return sessionServerIp;
    }

    public void setSessionServerIp(String sessionServerIp) {
        this.sessionServerIp = sessionServerIp;
    }

    public String getSessionServerPort() {
        return sessionServerPort;
    }

    public void setSessionServerPort(String sessionServerPort) {
        this.sessionServerPort = sessionServerPort;
    }

    public String getSessionDbInstanceName() {
        return sessionDbInstanceName;
    }

    public void setSessionDbInstanceName(String sessionDbInstanceName) {
        this.sessionDbInstanceName = sessionDbInstanceName;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getSessionDbEdition() {
        return sessionDbEdition;
    }

    public void setSessionDbEdition(String sessionDbEdition) {
        this.sessionDbEdition = sessionDbEdition;
    }

    public String getAppClientip() {
        return appClientip;
    }

    public void setAppClientip(String appClientip) {
        this.appClientip = appClientip;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getAppClientport() {
        return appClientport;
    }

    public void setAppClientport(String appClientport) {
        this.appClientport = appClientport;
    }

    public String getSessionClientMac() {
        return sessionClientMac;
    }

    public void setSessionClientMac(String sessionClientMac) {
        this.sessionClientMac = sessionClientMac;
    }

    public String getClientProgram() {
        return clientProgram;
    }

    public void setClientProgram(String clientProgram) {
        this.clientProgram = clientProgram;
    }

    public String getClientSystemUser() {
        return clientSystemUser;
    }

    public void setClientSystemUser(String clientSystemUser) {
        this.clientSystemUser = clientSystemUser;
    }

    public String getAppClientUsername() {
        return appClientUsername;
    }

    public void setAppClientUsername(String appClientUsername) {
        this.appClientUsername = appClientUsername;
    }

    public String getDbUsername() {
        return dbUsername;
    }

    public void setDbUsername(String dbUsername) {
        this.dbUsername = dbUsername;
    }

    public String getRiskType() {
        return riskType;
    }

    public void setRiskType(String riskType) {
        this.riskType = riskType;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getEngineAction() {
        return engineAction;
    }

    public void setEngineAction(String engineAction) {
        this.engineAction = engineAction;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public String getAccessObject() {
        return accessObject;
    }

    public void setAccessObject(String accessObject) {
        this.accessObject = accessObject;
    }

    public String getExecCostUs() {
        return execCostUs;
    }

    public void setExecCostUs(String execCostUs) {
        this.execCostUs = execCostUs;
    }

    public String getResultsEnforcement() {
        return resultsEnforcement;
    }

    public void setResultsEnforcement(String resultsEnforcement) {
        this.resultsEnforcement = resultsEnforcement;
    }

    public String getAffectRows() {
        return affectRows;
    }

    public void setAffectRows(String affectRows) {
        this.affectRows = affectRows;
    }

    public String getSqlFullText() {
        return sqlFullText;
    }

    public void setSqlFullText(String sqlFullText) {
        this.sqlFullText = sqlFullText;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getMemo() {
        return memo;
    }


    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
