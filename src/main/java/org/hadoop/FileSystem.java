package org.hadoop;

import javax.security.auth.login.AppConfigurationEntry;
import javax.security.auth.login.Configuration;
import java.nio.file.FileSystem;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-08-05 5:43 下午
 */
public class FileSystem {
    Configuration configuration = new Configuration() {
    };
    FileSystem hdfs = FileSystem.get(configuration);
    FileSystem local = FileSystem.getLocal(configuration);

}
