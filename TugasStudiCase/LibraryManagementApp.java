/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TugasStudiCase;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author syrly
 */
public class LibraryManagementApp extends JFrame{

    private DefaultTableModel tableModel;
    private JTable bookTable;

    public LibraryManagementApp() {
        setTitle("Aplikasi Manajemen Buku Perpustakaan");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Membuat MenuBar
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem menuItemAddBook = new JMenuItem("Tambah Buku");
        menu.add(menuItemAddBook);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        // Panel Utama
        JPanel mainPanel = new JPanel(new BorderLayout());
        getContentPane().add(mainPanel);

        // Tabel untuk menampilkan data buku
        tableModel = new DefaultTableModel(new String[]{"Judul", "Penulis", "Genre", "Halaman", "Deskripsi", "Rating", "Format", "Status", "Kategori"}, 0);
        bookTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(bookTable);
        mainPanel.add(tableScrollPane, BorderLayout.CENTER);

        // Panel Form Input Buku
        BookFormPanel formPanel = new BookFormPanel();
        mainPanel.add(formPanel, BorderLayout.NORTH);

        // Menampilkan form ketika menu dipilih
        menuItemAddBook.addActionListener(e -> formPanel.setVisible(true));

        // Mendengarkan event submit form untuk menambah data ke JTable
        formPanel.setFormListener(book -> {
            Object[] row = new Object[]{
                    book.getTitle(),
                    book.getAuthor(),
                    book.getGenre(),
                    book.getPages(),
                    book.getDescription(),
                    book.getRating(),
                    book.getFormat(),
                    book.getStatus(),
                    book.getCategories()
            };
            tableModel.addRow(row);
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LibraryManagementApp().setVisible(true));
    }
}

// Panel Form Input Buku
class BookFormPanel extends JPanel {

    private JTextField titleField;
    private JTextField authorField;
    private JComboBox<String> genreComboBox;
    private JSpinner pagesSpinner;
    private JTextArea descriptionArea;
    private JSlider ratingSlider;
    private JList<String> formatList;
    private JRadioButton rbAvailable, rbNotAvailable;
    private JCheckBox cbNewRelease, cbBestSeller;
    private JButton submitButton;
    private FormListener formListener;

    public BookFormPanel() {
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createTitledBorder("Form Input Buku"));

        GridBagConstraints gc = new GridBagConstraints();
        gc.insets = new Insets(5, 5, 5, 5);

        // Komponen Form Input Buku
        titleField = new JTextField(15);
        authorField = new JTextField(15);
        genreComboBox = new JComboBox<>(new String[]{"Fiksi", "Non-Fiksi", "Biografi", "Sains", "Sejarah", "Romansa"});
        pagesSpinner = new JSpinner(new SpinnerNumberModel(100, 10, 1000, 10));
        descriptionArea = new JTextArea(3, 15);
        ratingSlider = new JSlider(1, 5, 3); // Rating dari 1 sampai 5
        ratingSlider.setMajorTickSpacing(1);
        ratingSlider.setPaintTicks(true);
        ratingSlider.setPaintLabels(true);
        
        // JList untuk format buku
        formatList = new JList<>(new String[]{"Hardcover", "Paperback", "eBook", "Audiobook"});
        formatList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // RadioButton untuk status ketersediaan
        rbAvailable = new JRadioButton("Tersedia");
        rbNotAvailable = new JRadioButton("Tidak Tersedia");
        ButtonGroup availabilityGroup = new ButtonGroup();
        availabilityGroup.add(rbAvailable);
        availabilityGroup.add(rbNotAvailable);

        // CheckBox untuk kategori tambahan
        cbNewRelease = new JCheckBox("Rilis Baru");
        cbBestSeller = new JCheckBox("Best Seller");

        // Label dan Input Form
        gc.gridx = 0; gc.gridy = 0;
        add(new JLabel("Judul Buku: "), gc);
        gc.gridx = 1;
        add(titleField, gc);

        gc.gridx = 0; gc.gridy++;
        add(new JLabel("Penulis: "), gc);
        gc.gridx = 1;
        add(authorField, gc);

        gc.gridx = 0; gc.gridy++;
        add(new JLabel("Genre: "), gc);
        gc.gridx = 1;
        add(genreComboBox, gc);

        gc.gridx = 0; gc.gridy++;
        add(new JLabel("Jumlah Halaman: "), gc);
        gc.gridx = 1;
        add(pagesSpinner, gc);

        gc.gridx = 0; gc.gridy++;
        add(new JLabel("Deskripsi: "), gc);
        gc.gridx = 1;
        add(new JScrollPane(descriptionArea), gc);

        gc.gridx = 0; gc.gridy++;
        add(new JLabel("Rating: "), gc);
        gc.gridx = 1;
        add(ratingSlider, gc);

        gc.gridx = 0; gc.gridy++;
        add(new JLabel("Format Buku: "), gc);
        gc.gridx = 1;
        add(new JScrollPane(formatList), gc);

        gc.gridx = 0; gc.gridy++;
        add(new JLabel("Status Ketersediaan: "), gc);
        JPanel availabilityPanel = new JPanel();
        availabilityPanel.add(rbAvailable);
        availabilityPanel.add(rbNotAvailable);
        gc.gridx = 1;
        add(availabilityPanel, gc);

        gc.gridx = 0; gc.gridy++;
        add(new JLabel("Kategori Tambahan: "), gc);
        JPanel categoryPanel = new JPanel();
        categoryPanel.add(cbNewRelease);
        categoryPanel.add(cbBestSeller);
        gc.gridx = 1;
        add(categoryPanel, gc);

        // Tombol Submit
        submitButton = new JButton("Tambah Buku");
        gc.gridx = 1; gc.gridy++;
        add(submitButton, gc);

        // Event Listener untuk tombol submit
        submitButton.addActionListener((ActionEvent e) -> {
            String title = titleField.getText();
            String author = authorField.getText();
            String genre = (String) genreComboBox.getSelectedItem();
            int pages = (int) pagesSpinner.getValue();
            String description = descriptionArea.getText();
            int rating = ratingSlider.getValue();
            String format = formatList.getSelectedValue();
            String status = rbAvailable.isSelected() ? "Tersedia" : "Tidak Tersedia";
            String categories = "";
            if (cbNewRelease.isSelected()) categories += "Rilis Baru ";
            if (cbBestSeller.isSelected()) categories += "Best Seller ";

            if (formListener != null) {
                // Pastikan objek Book diberikan dengan benar
                formListener.formEventOccurred(new Book(title, author, genre, pages, description, rating, format, status, categories.trim()));
            }

            // Reset form input setelah submit
            titleField.setText("");
            authorField.setText("");
            genreComboBox.setSelectedIndex(0);
            pagesSpinner.setValue(100);
            descriptionArea.setText("");
            ratingSlider.setValue(3);
            formatList.clearSelection();
            availabilityGroup.clearSelection();
            cbNewRelease.setSelected(false);
            cbBestSeller.setSelected(false);
        });

    }

    public void setFormListener(FormListener listener) {
        this.formListener = listener;
    }
}

// Interface untuk Form Listener
interface FormListener {
    void formEventOccurred(Book book); // Pastikan tipe parameter adalah Book
}


// Kelas Buku
class Book {
    private String title;
    private String author;
    private String genre;
    private int pages;
    private String description;
    private int rating;
    private String format;
    private String status;
    private String categories;

    public Book(String title, String author, String genre, int pages, String description, int rating, String format, String status, String categories) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.pages = pages;
        this.description = description;
        this.rating = rating;
        this.format = format;
        this.status = status;
        this.categories = categories;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getGenre() { return genre; }
    public int getPages() { return pages; }
    public String getDescription() { return description; }
    public int getRating() { return rating; }
    public String getFormat() { return format; }
    public String getStatus() { return status; }
    public String getCategories() { return categories; }

}
