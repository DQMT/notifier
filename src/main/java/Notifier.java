import email.Email;
import email.EmailUtil;
import lombok.extern.slf4j.Slf4j;
import option.Options;

import javax.mail.MessagingException;
import java.io.IOException;

/**
 * @ Date       ：Created in 14:33 2019/6/6
 * @ Modified By：
 * @ Version:     0.1
 */
@Slf4j
public class Notifier {
    public static void main(String[] args) throws IOException, MessagingException, InterruptedException {
        if (args.length != 1) {
            log.error("usage : java -jar notifier-1.0-SNAPSHOT-jar-with-dependencies.jar yourMessage ");
            System.exit(-1);
        }
        String msg = args[0];
        Options options = Options.getInstance("email.properties");
        Email email = new Email(options.getProperties());
        email.setText(msg);
        EmailUtil.sendEmail(email);
    }
}