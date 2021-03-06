package window;

import gameCore.Game;
import gameCore.GameHandler;
import gameCore.GameParams;
import gameEntitiesAttributes.CharacterAttributes;
import gameEntitiesAttributes.MonsterAttributes;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import npcControls.NPCDialogWindow;
import user.User;
import utilities.XMLManager;

public class WindowController {

    private GameHandler gameHandler;
    private Stage dialogWindow;
    private boolean dialogShown;
    @FXML
    private Canvas mainCanvas;

    @FXML
    private void initialize(){
        this.mainCanvas.setFocusTraversable(true);
        MonsterAttributes[] monstersDefinitions = XMLManager.loadMonsters();
        CharacterAttributes userDefinition = XMLManager.loadUser();
        this.gameHandler = new GameHandler(this, monstersDefinitions);
        User user = new User(this.gameHandler, userDefinition);
        this.gameHandler.initialize(user);

        this.dialogShown = false;
        Timeline fiveSecondsWonder = new Timeline(
                new KeyFrame(Duration.millis(1000 / GameParams.TICKS_PER_SECOND),
                        event -> checkNpc()));
        fiveSecondsWonder.setCycleCount(Timeline.INDEFINITE);
        fiveSecondsWonder.play();

        new Game(gameHandler).start();
    }

    private void checkNpc() {
        //gonna change that later...
        if (this.gameHandler.getNpcSpokenTo() != null) {
            if(!this.dialogShown) {
                this.dialogWindow = new NPCDialogWindow(this.gameHandler);
                this.dialogWindow.show();
                this.dialogShown = true;
            }
        } else {
            dialogShown = false;
            if(this.dialogWindow != null) {
                this.dialogWindow.close();
                this.dialogWindow = null;
            }
        }
    }

    public Canvas getCanvas() {
        return this.mainCanvas;
    }
}
