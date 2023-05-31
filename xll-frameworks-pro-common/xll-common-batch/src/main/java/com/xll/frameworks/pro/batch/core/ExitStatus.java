package com.xll.frameworks.pro.batch.core;

/**
 * 功能描述: <br>
 * <p>
 *  <结果状态>
 * </p>
 * @author xuliangliang
 * @since 2023/6/1 00:06
 * @version 1.0.0
 */
public class ExitStatus {
    public static final ExitStatus EXECUTING = new ExitStatus("EXECUTING");

    private final String exitCode;

    private final String exitDescription;

    public ExitStatus(String exitCode) {
        this(exitCode, "");
    }

    public ExitStatus(String exitCode, String exitDescription) {
        this.exitCode = exitCode;
        this.exitDescription = exitDescription;
    }

    public String getExitCode() {
        return exitCode;
    }

    public String getExitDescription() {
        return exitDescription;
    }
}
