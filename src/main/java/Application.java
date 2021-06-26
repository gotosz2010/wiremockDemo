import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

/**
 * 启动一个 Mock 服务，并定义服务的 Host 是 localhost，端口是 9090
 */
public class Application {
    // 定义 mock 服务的端口
    private static final int PORT = 9090;

    // 定义 mock 服务的地址
    private static final String LOCALHOST = "localhost";

    // 定义 mapping 文件目录
    private static final String MOCK_DIR = "mock";

    // main 方法中的内容为启动 mock 服务的固定写法
    public static void main(String[] args) {
        WireMockConfiguration config = wireMockConfig().port(PORT).usingFilesUnderClasspath(MOCK_DIR);
        WireMockServer wireMockServer = new WireMockServer(config);
        wireMockServer.start();
        WireMock.configureFor(LOCALHOST, PORT);
    }

}