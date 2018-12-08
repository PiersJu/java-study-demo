import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

/***
 * @author Piers
 * @date 2018/12/8 12:03
 **/
@ServerEndpoint("/pchat")
public class WebsocketTest {
    private static AtomicInteger onlineCount = new AtomicInteger(0);
    private static CopyOnWriteArraySet<WebsocketTest> websocketSet = new CopyOnWriteArraySet<>();

    private Session session;

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        websocketSet.add(this);
        int count = onlineCount.addAndGet(1);
        System.out.println("有新连接加入！当前在线人数为:" + count);
    }

    @OnClose
    public void onClose(Session session) {
        websocketSet.remove(this);
        int count = onlineCount.decrementAndGet();
        System.out.println("有一连接关闭！当前在线人数为:" + count);
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("来自客户端的消息:" + message);
        for (WebsocketTest client : websocketSet) {
            try {
                client.sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }

    public void sendMessage(String message) throws IOException {
        // this.session.getBasicRemote().sendText(message);
        this.session.getAsyncRemote().sendText(message);
    }
}
