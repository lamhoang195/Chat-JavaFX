package app;

import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.layout.BorderPane;

public class ChatController {
    @FXML
    private AnchorPane pane;

    @FXML
    private TextField textField;

    @FXML
    private VBox messageContainer; // Thêm VBox để chứa các tin nhắn

    @FXML
    private void sendMessage() {
        String message = textField.getText();
        if (!message.isEmpty()) {
            Text newMessage = new Text(message);
            newMessage.setFill(Color.BLACK);

            BorderPane messageBubble = new BorderPane();
            messageBubble.setCenter(newMessage);

            Rectangle bubbleBackground = new Rectangle(newMessage.getLayoutBounds().getWidth() + 20, newMessage.getLayoutBounds().getHeight() + 20);
            bubbleBackground.setArcWidth(10);
            bubbleBackground.setArcHeight(10);
            bubbleBackground.setFill(Color.LIGHTBLUE);

            messageBubble.setPadding(new javafx.geometry.Insets(10));
            messageBubble.setBackground(new javafx.scene.layout.Background(new javafx.scene.layout.BackgroundFill(Color.LIGHTBLUE, new javafx.scene.layout.CornerRadii(10), null)));

            messageBubble.setMaxWidth(newMessage.getLayoutBounds().getWidth() + 40);
            newMessage.setTextAlignment(TextAlignment.LEFT);

            // Add the message to the VBox
            messageContainer.getChildren().add(messageBubble);

            // Check layoutY position and trigger scrollbar if needed
            if (messageContainer.getLayoutBounds().getMaxY() > 489) {
                ScrollPane scrollPane = (ScrollPane) messageContainer.getParent();
                scrollPane.setVvalue(1.0);
            }

            textField.clear();
        }
    }

}
