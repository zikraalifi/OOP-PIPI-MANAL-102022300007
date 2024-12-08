import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;

public class InventoryController {

    @FXML
    private TableView<Album> tableAlbum;
    @FXML
    private TableColumn<Album, String> columnAlbumName;
    @FXML
    private TableColumn<Album, String> columnArtist;
    @FXML
    private TableColumn<Album, Integer> columnAvailable;
    @FXML
    private TableColumn<Album, Integer> columnTotal;

    @FXML
    private TextField albumNameField;
    @FXML
    private TextField artistField;
    @FXML
    private TextField totalField;
    @FXML
    private TextField availableField;

    @FXML
    private Button addButton;
    @FXML
    private Button deleteButton;
    @FXML
    private Button updateButton;
    @FXML
    private Button rentButton;

    private ObservableList<Album> albumList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        columnAlbumName.setCellValueFactory(new PropertyValueFactory<>("albumName"));
        columnArtist.setCellValueFactory(new PropertyValueFactory<>("artist"));
        columnAvailable.setCellValueFactory(new PropertyValueFactory<>("available"));
        columnTotal.setCellValueFactory(new PropertyValueFactory<>("total"));

        albumList.addAll(
            new Album("The Black Parade", "My Chemical Romance", 5, 14),
            new Album("21st Century Breakdown", "Green Day", 11, 18),
            new Album("Freudian", "Daniel Caesar", 10, 2)
        );

        tableAlbum.setItems(albumList);
    }

    @FXML
    private void handleAddButton() {
        try {
            String albumName = albumNameField.getText();
            String artist = artistField.getText();
            int total = Integer.parseInt(totalField.getText());
            int available = Integer.parseInt(availableField.getText());

            Album newAlbum = new Album(albumName, artist, total, available);
            albumList.add(newAlbum);

            clearFields();
            showAlert(Alert.AlertType.INFORMATION, "Album '" + albumName + "' berhasil ditambahkan!");
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Silahkan cek data yang anda masukkan");
        }
    }

    @FXML
    private void handleDeleteButton() {
        Album selectedAlbum = tableAlbum.getSelectionModel().getSelectedItem();
        if (selectedAlbum != null) {
            albumList.remove(selectedAlbum);
            showAlert(Alert.AlertType.INFORMATION, "Album '" + selectedAlbum.getAlbumName() + "' berhasil dihapus!");
        } else {
            showAlert(Alert.AlertType.WARNING, "Pilih album yang ingin dihapus.");
        }
    }

    @FXML
    private void handleUpdateButton() {
        Album selectedAlbum = tableAlbum.getSelectionModel().getSelectedItem();
        if (selectedAlbum != null) {
            try {
                selectedAlbum.setAlbumName(albumNameField.getText());
                selectedAlbum.setArtist(artistField.getText());
                selectedAlbum.setTotal(Integer.parseInt(totalField.getText()));
                selectedAlbum.setAvailable(Integer.parseInt(availableField.getText()));

                tableAlbum.refresh();
                clearFields();
                showAlert(Alert.AlertType.INFORMATION, "Album '" + selectedAlbum.getAlbumName() + "' berhasil diperbarui!");
            } catch (NumberFormatException e) {
                showAlert(Alert.AlertType.ERROR, "Input tidak valid. Pastikan jumlah adalah angka.");
            }
        } else {
            showAlert(Alert.AlertType.WARNING, "Pilih album yang ingin diperbarui.");
        }
    }

    @FXML
    private void handleRentButton() {
        Album selectedAlbum = tableAlbum.getSelectionModel().getSelectedItem();
        if (selectedAlbum != null && selectedAlbum.getAvailable() > 0) {
            selectedAlbum.setAvailable(selectedAlbum.getAvailable() - 1);
            tableAlbum.refresh();
            showAlert(Alert.AlertType.INFORMATION, "Album '" + selectedAlbum.getAlbumName() + "' berhasil disewa!");
        } else {
            showAlert(Alert.AlertType.WARNING, "Pilih album yang tersedia untuk disewa.");
        }
    }

    private void clearFields() {
        albumNameField.clear();
        artistField.clear();
        totalField.clear();
        availableField.clear();
    }

    private void showAlert(Alert.AlertType alertType, String message) {
        Alert alert = new Alert(alertType);
        alert.setContentText(message);
        alert.show();
    }
}
