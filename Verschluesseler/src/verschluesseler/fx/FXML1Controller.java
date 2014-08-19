/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package verschluesseler.fx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import verschluesseler.Uebersetzer;

/**
 * FXML Controller class
 *
 * @author Felix
 */
public class FXML1Controller {

    private Uebersetzer uebersetzer = new Uebersetzer();
    @FXML private TextField codeword;
    @FXML private TextArea in;
    @FXML private TextArea out;
  
    
    @FXML protected void handleEncodeButtonAction(ActionEvent event) {
        out.setText(uebersetzer.codiere(codeword.getText(), in.getText()));
    }
    @FXML protected void handleDecodeButtonAction(ActionEvent event) {
        out.setText(uebersetzer.decodiere(codeword.getText(), in.getText()));
    }
}
