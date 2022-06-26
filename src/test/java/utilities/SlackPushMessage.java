package utilities;

import com.slack.api.Slack;
import com.slack.api.webhook.Payload;
import com.slack.api.webhook.WebhookResponse;

import java.io.IOException;

public class SlackPushMessage implements TestResultMessage {

    Payload payload;
    //That channel was created by me ofr just test result sharing.
    String slackWebhookUrl = "https://hooks.slack.com/services/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";

    @Override
    public void pushTestResultMessage(String textMessage) {


        Slack slack = Slack.getInstance();

        payload = Payload.builder().
                text(textMessage).
                build();

        try {
            WebhookResponse response = slack.send(slackWebhookUrl, payload);
            System.out.println(response);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
