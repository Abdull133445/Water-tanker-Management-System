//////package DSAProject;
//////
//////import javax.swing.*;
//////import java.awt.*;
//////
//////public class Customer {
//////    private JFrame frame;
//////    private JTextField nameField, cnicField, contactField, addressField;
//////    private JComboBox<String> tankerSizeBox, deliveryTypeBox;
//////
//////    public Customer() {
//////        // Set up the main frame
//////        frame = new JFrame("Customer Portal - Water Tanker Scheduler");
//////        frame.setSize(1200, 700);
//////        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//////        frame.setLayout(new BorderLayout());
//////        frame.setLocationRelativeTo(null); // Center the frame on the screen
//////
//////        // Background Panel
//////        JPanel backgroundPanel = new JPanel(new BorderLayout()) {
//////            private Image backgroundImage = new ImageIcon("C:/Users/dell/IdeaProjects/DSAProject/src/resources/Water_Drop_Truck_Logo-removebg.png").getImage();
//////
//////            @Override
//////            protected void paintComponent(Graphics g) {
//////                super.paintComponent(g);
//////                if (backgroundImage != null) {
//////                    Graphics2D g2d = (Graphics2D) g.create();
//////                    // Set transparency
//////                    g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f)); // 60% opacity
//////                    g2d.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
//////                    g2d.dispose();
//////                }
//////            }
//////        };
//////
//////        // Header Panel with Water-Themed Design
//////        JPanel headerPanel = new JPanel() {
//////            @Override
//////            protected void paintComponent(Graphics g) {
//////                super.paintComponent(g);
//////                Graphics2D g2d = (Graphics2D) g;
//////                g2d.setPaint(new GradientPaint(0, 0, new Color(0, 51, 102), getWidth(), 0, new Color(16, 177, 224)));
//////                g2d.fillRect(0, 0, getWidth(), getHeight());
//////            }
//////        };
//////        JLabel headerLabel = new JLabel("Customer Portal - Water Tanker Scheduler");
//////        headerLabel.setForeground(Color.WHITE);
//////        headerLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
//////        headerPanel.add(headerLabel);
//////        headerPanel.setOpaque(false); // Make header panel transparent
//////        backgroundPanel.add(headerPanel, BorderLayout.NORTH);
//////
//////        // Center Panel for Input Fields
//////        JPanel centerPanel = new JPanel(new GridBagLayout());
//////        centerPanel.setOpaque(false);
//////        centerPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30)); // Add padding
//////
//////        GridBagConstraints gbc = new GridBagConstraints();
//////        gbc.insets = new Insets(15, 15, 15, 15);
//////        gbc.anchor = GridBagConstraints.CENTER;
//////
//////        JLabel nameLabel = new JLabel("Name:");
//////        nameLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
//////        nameLabel.setForeground(Color.BLACK);
//////        gbc.gridx = 0;
//////        gbc.gridy = 0;
//////        centerPanel.add(nameLabel, gbc);
//////
//////        nameField = new JTextField(25);
//////        nameField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
//////        gbc.gridx = 1;
//////        centerPanel.add(nameField, gbc);
//////
//////        JLabel cnicLabel = new JLabel("CNIC Number:");
//////        cnicLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
//////        cnicLabel.setForeground(Color.BLACK);
//////        gbc.gridx = 0;
//////        gbc.gridy = 1;
//////        centerPanel.add(cnicLabel, gbc);
//////
//////        cnicField = new JTextField(25);
//////        cnicField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
//////        gbc.gridx = 1;
//////        centerPanel.add(cnicField, gbc);
//////
//////        JLabel contactLabel = new JLabel("Contact Number:");
//////        contactLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
//////        contactLabel.setForeground(Color.BLACK);
//////        gbc.gridx = 0;
//////        gbc.gridy = 2;
//////        centerPanel.add(contactLabel, gbc);
//////
//////        contactField = new JTextField(25);
//////        contactField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
//////        gbc.gridx = 1;
//////        centerPanel.add(contactField, gbc);
//////
//////        JLabel addressLabel = new JLabel("Address:");
//////        addressLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
//////        addressLabel.setForeground(Color.BLACK);
//////        gbc.gridx = 0;
//////        gbc.gridy = 3;
//////        centerPanel.add(addressLabel, gbc);
//////
//////        addressField = new JTextField(25);
//////        addressField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
//////        gbc.gridx = 1;
//////        centerPanel.add(addressField, gbc);
//////
//////        JLabel tankerSizeLabel = new JLabel("Tanker Size:");
//////        tankerSizeLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
//////        tankerSizeLabel.setForeground(Color.BLACK);
//////        gbc.gridx = 0;
//////        gbc.gridy = 4;
//////        centerPanel.add(tankerSizeLabel, gbc);
//////
//////        tankerSizeBox = new JComboBox<>(new String[]{"1000 gallons", "2000 gallons"});
//////        tankerSizeBox.setFont(new Font("Times New Roman", Font.PLAIN, 18));
//////        gbc.gridx = 1;
//////        centerPanel.add(tankerSizeBox, gbc);
//////
//////        JLabel deliveryTypeLabel = new JLabel("Delivery Type:");
//////        deliveryTypeLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
//////        deliveryTypeLabel.setForeground(Color.BLACK);
//////        gbc.gridx = 0;
//////        gbc.gridy = 5;
//////        centerPanel.add(deliveryTypeLabel, gbc);
//////
//////        deliveryTypeBox = new JComboBox<>(new String[]{"Normal", "Emergency"});
//////        deliveryTypeBox.setFont(new Font("Times New Roman", Font.PLAIN, 18));
//////        gbc.gridx = 1;
//////        centerPanel.add(deliveryTypeBox, gbc);
//////
//////        backgroundPanel.add(centerPanel, BorderLayout.CENTER);
//////
//////        // Footer Panel with Buttons
//////        JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20)) {
//////            @Override
//////            protected void paintComponent(Graphics g) {
//////                super.paintComponent(g);
//////                Graphics2D g2d = (Graphics2D) g;
//////                g2d.setPaint(new GradientPaint(0, 0, new Color(16, 177, 224), getWidth(), 0, new Color(0, 51, 102)));
//////                g2d.fillRect(0, 0, getWidth(), getHeight());
//////            }
//////        };
//////
//////        JButton submitButton = createStyledButton("Submit Request");
//////        JButton exitButton = createStyledButton("Exit");
//////        footerPanel.add(submitButton);
//////        footerPanel.add(exitButton);
//////        footerPanel.setOpaque(false);
//////        backgroundPanel.add(footerPanel, BorderLayout.SOUTH);
//////
//////        // Action Listeners
//////        submitButton.addActionListener(e -> submitRequest());
//////        exitButton.addActionListener(e -> frame.dispose());
//////
//////        frame.add(backgroundPanel);
//////        frame.setVisible(true);
//////    }
//////
//////    private JButton createStyledButton(String text) {
//////        JButton button = new JButton(text);
//////        button.setFont(new Font("Times New Roman", Font.BOLD, 16));
//////        button.setForeground(Color.WHITE);
//////        button.setBackground(new Color(0, 153, 204));
//////        button.setFocusPainted(false);
//////        button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
//////        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
//////        button.setOpaque(true);
//////        button.setPreferredSize(new Dimension(180, 40));
//////        return button;
//////    }
//////
//////    private void submitRequest() {
//////        String name = nameField.getText().trim();
//////        String cnic = cnicField.getText().trim();
//////        String contact = contactField.getText().trim();
//////        String address = addressField.getText().trim();
//////        int tankerSize = tankerSizeBox.getSelectedIndex() == 0 ? 1000 : 2000;
//////        String deliveryType = (String) deliveryTypeBox.getSelectedItem();
//////
//////        if (name.isEmpty() || cnic.isEmpty() || contact.isEmpty() || address.isEmpty() || deliveryType == null) {
//////            JOptionPane.showMessageDialog(frame, "Please fill all the fields!", "Error", JOptionPane.ERROR_MESSAGE);
//////            return;
//////        }
//////
//////        JOptionPane.showMessageDialog(frame, "Your request has been submitted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
//////    }
//////
//////    public static void main(String[] args) {
//////        SwingUtilities.invokeLater(Customer::new);
//////    }
//////}
////package DSAProject;
////
////import javax.swing.*;
////import java.awt.*;
////
////public class Customer {
////    private JFrame frame;
////    private JTextField nameField, cnicField, contactField, addressField;
////    private JComboBox<String> tankerSizeBox, deliveryTypeBox;
////
////    public Customer() {
////        // Set up the main frame
////        frame = new JFrame("Customer Portal - Water Tanker Scheduler");
////        frame.setSize(1200, 700);
////        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////        frame.setLayout(new BorderLayout());
////        frame.setLocationRelativeTo(null); // Center the frame on the screen
////
////        // Background Panel
////        JPanel backgroundPanel = new JPanel(new BorderLayout()) {
////            private Image backgroundImage = new ImageIcon("C:/Users/dell/IdeaProjects/DSAProject/src/resources/Water_Drop_Truck_Logo-removebg.png").getImage();
////
////            @Override
////            protected void paintComponent(Graphics g) {
////                super.paintComponent(g);
////                if (backgroundImage != null) {
////                    Graphics2D g2d = (Graphics2D) g.create();
////                    // Set transparency
////                    g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.6f)); // 0.6f for 60% opacity
////                    g2d.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
////                    g2d.dispose();
////                }
////            }
////        };
////
////        // Header Panel with Water-Themed Design
////        JPanel headerPanel = new JPanel() {
////            @Override
////            protected void paintComponent(Graphics g) {
////                super.paintComponent(g);
////                Graphics2D g2d = (Graphics2D) g;
////                g2d.setPaint(new GradientPaint(0, 0, new Color(0, 51, 102), getWidth(), 0, new Color(16, 177, 224)));
////                g2d.fillRect(0, 0, getWidth(), getHeight());
////            }
////        };
////        JLabel headerLabel = new JLabel("Customer Portal - Water Tanker Scheduler");
////        headerLabel.setForeground(Color.WHITE);
////        headerLabel.setFont(new Font("Pacifico", Font.BOLD, 28));
////        headerPanel.add(headerLabel);
////        headerPanel.setOpaque(false); // Make header panel transparent
////        backgroundPanel.add(headerPanel, BorderLayout.NORTH);
////
////        // Center Panel for Input Fields
////        JPanel centerPanel = new JPanel(new GridBagLayout());
////        centerPanel.setOpaque(false);
////        centerPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30)); // Add padding
////
////        GridBagConstraints gbc = new GridBagConstraints();
////        gbc.insets = new Insets(15, 15, 15, 15);
////        gbc.anchor = GridBagConstraints.CENTER;
////
////        JLabel nameLabel = new JLabel("Name:");
////        nameLabel.setFont(new Font("Poppins", Font.BOLD, 24));
////        nameLabel.setForeground(Color.BLACK); // Black text color
////        gbc.gridx = 0;
////        gbc.gridy = 0;
////        centerPanel.add(nameLabel, gbc);
////
////        nameField = new JTextField(25);
////        nameField.setFont(new Font("Poppins", Font.PLAIN, 18));
////        gbc.gridx = 1;
////        centerPanel.add(nameField, gbc);
////
////        JLabel cnicLabel = new JLabel("CNIC Number:");
////        cnicLabel.setFont(new Font("Poppins", Font.BOLD, 24));
////        cnicLabel.setForeground(Color.BLACK); // Black text color
////        gbc.gridx = 0;
////        gbc.gridy = 1;
////        centerPanel.add(cnicLabel, gbc);
////
////        cnicField = new JTextField(25);
////        cnicField.setFont(new Font("Poppins", Font.PLAIN, 18));
////        gbc.gridx = 1;
////        centerPanel.add(cnicField, gbc);
////
////        JLabel contactLabel = new JLabel("Contact Number:");
////        contactLabel.setFont(new Font("Poppins", Font.BOLD, 24));
////        contactLabel.setForeground(Color.BLACK); // Black text color
////        gbc.gridx = 0;
////        gbc.gridy = 2;
////        centerPanel.add(contactLabel, gbc);
////
////        contactField = new JTextField(25);
////        contactField.setFont(new Font("Poppins", Font.PLAIN, 18));
////        gbc.gridx = 1;
////        centerPanel.add(contactField, gbc);
////
////        JLabel addressLabel = new JLabel("Address:");
////        addressLabel.setFont(new Font("Poppins", Font.BOLD, 24));
////        addressLabel.setForeground(Color.BLACK); // Black text color
////        gbc.gridx = 0;
////        gbc.gridy = 3;
////        centerPanel.add(addressLabel, gbc);
////
////        addressField = new JTextField(25);
////        addressField.setFont(new Font("Poppins", Font.PLAIN, 18));
////        gbc.gridx = 1;
////        centerPanel.add(addressField, gbc);
////
////        JLabel tankerSizeLabel = new JLabel("Tanker Size:");
////        tankerSizeLabel.setFont(new Font("Poppins", Font.BOLD, 24));
////        tankerSizeLabel.setForeground(Color.BLACK); // Black text color
////        gbc.gridx = 0;
////        gbc.gridy = 4;
////        centerPanel.add(tankerSizeLabel, gbc);
////
////        tankerSizeBox = new JComboBox<>(new String[]{"1000 gallons", "2000 gallons"});
////        tankerSizeBox.setFont(new Font("Poppins", Font.PLAIN, 18));
////        gbc.gridx = 1;
////        centerPanel.add(tankerSizeBox, gbc);
////
////        JLabel deliveryTypeLabel = new JLabel("Delivery Type:");
////        deliveryTypeLabel.setFont(new Font("Poppins", Font.BOLD, 24));
////        deliveryTypeLabel.setForeground(Color.BLACK); // Black text color
////        gbc.gridx = 0;
////        gbc.gridy = 5;
////        centerPanel.add(deliveryTypeLabel, gbc);
////
////        deliveryTypeBox = new JComboBox<>(new String[]{"Normal", "Emergency"});
////        deliveryTypeBox.setFont(new Font("Poppins", Font.PLAIN, 18));
////        gbc.gridx = 1;
////        centerPanel.add(deliveryTypeBox, gbc);
////
////        backgroundPanel.add(centerPanel, BorderLayout.CENTER);
////
////        // Footer Panel with Buttons
////        JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20)) {
////            @Override
////            protected void paintComponent(Graphics g) {
////                super.paintComponent(g);
////                Graphics2D g2d = (Graphics2D) g;
////                g2d.setPaint(new GradientPaint(0, 0, new Color(16, 177, 224), getWidth(), 0, new Color(0, 51, 102)));
////                g2d.fillRect(0, 0, getWidth(), getHeight());
////            }
////        };
////
////        JButton submitButton = createStyledButton("Submit Request");
////        JButton exitButton = createStyledButton("Exit");
////        footerPanel.add(submitButton);
////        footerPanel.add(exitButton);
////        footerPanel.setOpaque(false);
////        backgroundPanel.add(footerPanel, BorderLayout.SOUTH);
////
////        // Action Listeners
////        submitButton.addActionListener(e -> submitRequest());
////        exitButton.addActionListener(e -> frame.dispose());
////
////        frame.add(backgroundPanel);
////        frame.setVisible(true);
////    }
////
////    private JButton createStyledButton(String text) {
////        JButton button = new JButton(text);
////        button.setFont(new Font("Poppins", Font.BOLD, 16));
////        button.setForeground(Color.WHITE);
////        button.setBackground(new Color(0, 153, 204));
////        button.setFocusPainted(false);
////        button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
////        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
////        button.setOpaque(true);
////        button.setPreferredSize(new Dimension(180, 40));
////        return button;
////    }
////
////    private void submitRequest() {
////        String name = nameField.getText().trim();
////        String cnic = cnicField.getText().trim();
////        String contact = contactField.getText().trim();
////        String address = addressField.getText().trim();
////        int tankerSize = tankerSizeBox.getSelectedIndex() == 0 ? 1000 : 2000;
////        String deliveryType = (String) deliveryTypeBox.getSelectedItem();
////
////        if (name.isEmpty() || cnic.isEmpty() || contact.isEmpty() || address.isEmpty() || deliveryType == null) {
////            JOptionPane.showMessageDialog(frame, "Please fill all the fields!", "Error", JOptionPane.ERROR_MESSAGE);
////            return;
////        }
////
////        JOptionPane.showMessageDialog(frame, "Your request has been submitted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
////    }
////
////    public static void main(String[] args) {
////        SwingUtilities.invokeLater(Customer::new);
////    }
////}
//package DSAProject;
//
//import javax.swing.*;
//import java.awt.*;
//
//public class Customer {
//    private JFrame frame;
//    private JTextField nameField, cnicField, contactField, addressField;
//    private JComboBox<String> tankerSizeBox, deliveryTypeBox;
//
//    public Customer() {
//        // Set up the main frame
//        frame = new JFrame("Customer Portal - Water Tanker Scheduler");
//        frame.setSize(1200, 700);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setLayout(new BorderLayout());
//        frame.setLocationRelativeTo(null); // Center the frame on the screen
//
//        // Background Panel
//        JPanel backgroundPanel = new JPanel(new BorderLayout()) {
//            private Image backgroundImage = new ImageIcon("C:/Users/dell/IdeaProjects/DSAProject/src/resources/Water_Drop_Truck_Logo-removebg.png").getImage();
//
//            @Override
//            protected void paintComponent(Graphics g) {
//                super.paintComponent(g);
//                if (backgroundImage != null) {
//                    Graphics2D g2d = (Graphics2D) g.create();
//                    // Set transparency
//                    g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f)); // 0.6f for 60% opacity
//                    g2d.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
//                    g2d.dispose();
//                }
//            }
//        };
//
//        // Header Panel with Water-Themed Design
//        JPanel headerPanel = new JPanel() {
//            @Override
//            protected void paintComponent(Graphics g) {
//                super.paintComponent(g);
//                Graphics2D g2d = (Graphics2D) g;
//                g2d.setPaint(new GradientPaint(0, 0, new Color(0, 51, 102), getWidth(), 0, new Color(16, 177, 224)));
//                g2d.fillRect(0, 0, getWidth(), getHeight());
//            }
//        };
//        JLabel headerLabel = new JLabel("Customer Portal - Water Tanker Scheduler");
//        headerLabel.setForeground(Color.WHITE);
//        headerLabel.setFont(new Font("Pacifico", Font.BOLD, 28));
//        headerPanel.add(headerLabel);
//        headerPanel.setOpaque(false); // Make header panel transparent
//        backgroundPanel.add(headerPanel, BorderLayout.NORTH);
//
//        // Center Panel for Input Fields
//        JPanel centerPanel = new JPanel(new GridBagLayout());
//        centerPanel.setOpaque(false);
//        centerPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30)); // Add padding
//
//        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.insets = new Insets(15, 15, 15, 15);
//        gbc.anchor = GridBagConstraints.CENTER;
//
//        JLabel nameLabel = new JLabel("Name:");
//        nameLabel.setFont(new Font("Poppins", Font.BOLD, 24));
//        nameLabel.setForeground(Color.BLACK); // Black text color
//        gbc.gridx = 0;
//        gbc.gridy = 0;
//        centerPanel.add(nameLabel, gbc);
//
//        nameField = new JTextField(25);
//        nameField.setFont(new Font("Poppins", Font.PLAIN, 18));
//        gbc.gridx = 1;
//        centerPanel.add(nameField, gbc);
//
//        JLabel cnicLabel = new JLabel("CNIC Number:");
//        cnicLabel.setFont(new Font("Poppins", Font.BOLD, 24));
//        cnicLabel.setForeground(Color.BLACK); // Black text color
//        gbc.gridx = 0;
//        gbc.gridy = 1;
//        centerPanel.add(cnicLabel, gbc);
//
//        cnicField = new JTextField(25);
//        cnicField.setFont(new Font("Poppins", Font.PLAIN, 18));
//        gbc.gridx = 1;
//        centerPanel.add(cnicField, gbc);
//
//        JLabel contactLabel = new JLabel("Contact Number:");
//        contactLabel.setFont(new Font("Poppins", Font.BOLD, 24));
//        contactLabel.setForeground(Color.BLACK); // Black text color
//        gbc.gridx = 0;
//        gbc.gridy = 2;
//        centerPanel.add(contactLabel, gbc);
//
//        contactField = new JTextField(25);
//        contactField.setFont(new Font("Poppins", Font.PLAIN, 18));
//        gbc.gridx = 1;
//        centerPanel.add(contactField, gbc);
//
//        JLabel addressLabel = new JLabel("Address:");
//        addressLabel.setFont(new Font("Poppins", Font.BOLD, 24));
//        addressLabel.setForeground(Color.BLACK); // Black text color
//        gbc.gridx = 0;
//        gbc.gridy = 3;
//        centerPanel.add(addressLabel, gbc);
//
//        addressField = new JTextField(25);
//        addressField.setFont(new Font("Poppins", Font.PLAIN, 18));
//        gbc.gridx = 1;
//        centerPanel.add(addressField, gbc);
//
//        JLabel tankerSizeLabel = new JLabel("Tanker Size:");
//        tankerSizeLabel.setFont(new Font("Poppins", Font.BOLD, 24));
//        tankerSizeLabel.setForeground(Color.BLACK); // Black text color
//        gbc.gridx = 0;
//        gbc.gridy = 4;
//        centerPanel.add(tankerSizeLabel, gbc);
//
//        tankerSizeBox = new JComboBox<>(new String[]{"1000 gallons", "2000 gallons"});
//        tankerSizeBox.setFont(new Font("Poppins", Font.PLAIN, 18));
//        gbc.gridx = 1;
//        centerPanel.add(tankerSizeBox, gbc);
//
//        JLabel deliveryTypeLabel = new JLabel("Delivery Type:");
//        deliveryTypeLabel.setFont(new Font("Poppins", Font.BOLD, 24));
//        deliveryTypeLabel.setForeground(Color.BLACK); // Black text color
//        gbc.gridx = 0;
//        gbc.gridy = 5;
//        centerPanel.add(deliveryTypeLabel, gbc);
//
//        deliveryTypeBox = new JComboBox<>(new String[]{"Normal", "Emergency"});
//        deliveryTypeBox.setFont(new Font("Poppins", Font.PLAIN, 18));
//        gbc.gridx = 1;
//        centerPanel.add(deliveryTypeBox, gbc);
//
//        backgroundPanel.add(centerPanel, BorderLayout.CENTER);
//
//        // Footer Panel with Buttons
//        JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20)) {
//            @Override
//            protected void paintComponent(Graphics g) {
//                super.paintComponent(g);
//                Graphics2D g2d = (Graphics2D) g;
//                g2d.setPaint(new GradientPaint(0, 0, new Color(16, 177, 224), getWidth(), 0, new Color(0, 51, 102)));
//                g2d.fillRect(0, 0, getWidth(), getHeight());
//            }
//        };
//
//        JButton submitButton = createStyledButton("Submit Request");
//        JButton exitButton = createStyledButton("Exit");
//        footerPanel.add(submitButton);
//        footerPanel.add(exitButton);
//        footerPanel.setOpaque(false);
//        backgroundPanel.add(footerPanel, BorderLayout.SOUTH);
//
//        // Action Listeners
//        submitButton.addActionListener(e -> submitRequest());
//        exitButton.addActionListener(e -> frame.dispose());
//
//        frame.add(backgroundPanel);
//        frame.setVisible(true);
//    }
//
//    private JButton createStyledButton(String text) {
//        JButton button = new JButton(text);
//        button.setFont(new Font("Poppins", Font.BOLD, 16));
//        button.setForeground(Color.WHITE);
//        button.setBackground(new Color(0, 153, 204));
//        button.setFocusPainted(false);
//        button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
//        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
//        button.setOpaque(true);
//        button.setPreferredSize(new Dimension(180, 40));
//        return button;
//    }
//
//    private void submitRequest() {
//        String name = nameField.getText().trim();
//        String cnic = cnicField.getText().trim();
//        String contact = contactField.getText().trim();
//        String address = addressField.getText().trim();
//        int tankerSize = tankerSizeBox.getSelectedIndex() == 0 ? 1000 : 2000;
//        String deliveryType = (String) deliveryTypeBox.getSelectedItem();
//
//        if (name.isEmpty() || cnic.isEmpty() || contact.isEmpty() || address.isEmpty() || deliveryType == null) {
//            JOptionPane.showMessageDialog(frame, "Please fill all the fields!", "Error", JOptionPane.ERROR_MESSAGE);
//            return;
//        }
//
//        WaterRequestScheduler scheduler = new WaterRequestScheduler();
//        scheduler.loadRequestsFromFile();
//        scheduler.addRequest(name, cnic, contact, address, tankerSize, deliveryType);
//        JOptionPane.showMessageDialog(frame, "Your request has been submitted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(Customer::new);
//    }
//}
//
package DSAProject;

import javax.swing.*;
import java.awt.*;

public class Customer {
    private JFrame frame;
    private JTextField nameField, cnicField, contactField, addressField;
    private JComboBox<String> tankerSizeBox, deliveryTypeBox;

    public Customer() {
        // Set up the main frame
        frame = new JFrame("Customer Portal - Water Tanker Scheduler");
        frame.setSize(1200, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null); // Center the frame on the screen

        // Background Panel
        JPanel backgroundPanel = new JPanel(new BorderLayout()) {
            private Image backgroundImage = new ImageIcon("C:/Users/dell/IdeaProjects/DSAProject/src/resources/Water_Drop_Truck_Logo-removebg.png").getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null) {
                    Graphics2D g2d = (Graphics2D) g.create();
                    // Set transparency
                    g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f)); // 60% opacity
                    g2d.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                    g2d.dispose();
                }
            }
        };

        // Header Panel with Water-Themed Design
        JPanel headerPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setPaint(new GradientPaint(0, 0, new Color(0, 51, 102), getWidth(), 0, new Color(16, 177, 224)));
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        JLabel headerLabel = new JLabel("Customer Portal - Water Tanker Scheduler");
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
        headerPanel.add(headerLabel);
        headerPanel.setOpaque(false); // Make header panel transparent
        backgroundPanel.add(headerPanel, BorderLayout.NORTH);

        // Center Panel for Input Fields
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setOpaque(false);
        centerPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30)); // Add padding

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);
        gbc.anchor = GridBagConstraints.CENTER;

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        nameLabel.setForeground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 0;
        centerPanel.add(nameLabel, gbc);

        nameField = new JTextField(25);
        nameField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        gbc.gridx = 1;
        centerPanel.add(nameField, gbc);

        JLabel cnicLabel = new JLabel("CNIC Number:");
        cnicLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        cnicLabel.setForeground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 1;
        centerPanel.add(cnicLabel, gbc);

        cnicField = new JTextField(25);
        cnicField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        gbc.gridx = 1;
        centerPanel.add(cnicField, gbc);

        JLabel contactLabel = new JLabel("Contact Number:");
        contactLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        contactLabel.setForeground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 2;
        centerPanel.add(contactLabel, gbc);

        contactField = new JTextField(25);
        contactField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        gbc.gridx = 1;
        centerPanel.add(contactField, gbc);

        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        addressLabel.setForeground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 3;
        centerPanel.add(addressLabel, gbc);

        addressField = new JTextField(25);
        addressField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        gbc.gridx = 1;
        centerPanel.add(addressField, gbc);

        JLabel tankerSizeLabel = new JLabel("Tanker Size:");
        tankerSizeLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        tankerSizeLabel.setForeground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 4;
        centerPanel.add(tankerSizeLabel, gbc);

        tankerSizeBox = new JComboBox<>(new String[]{"1000 gallons", "2000 gallons"});
        tankerSizeBox.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        gbc.gridx = 1;
        centerPanel.add(tankerSizeBox, gbc);

        JLabel deliveryTypeLabel = new JLabel("Delivery Type:");
        deliveryTypeLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        deliveryTypeLabel.setForeground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 5;
        centerPanel.add(deliveryTypeLabel, gbc);

        deliveryTypeBox = new JComboBox<>(new String[]{"Normal", "Emergency"});
        deliveryTypeBox.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        gbc.gridx = 1;
        centerPanel.add(deliveryTypeBox, gbc);

        backgroundPanel.add(centerPanel, BorderLayout.CENTER);

        // Footer Panel with Buttons
        JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20)) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setPaint(new GradientPaint(0, 0, new Color(16, 177, 224), getWidth(), 0, new Color(0, 51, 102)));
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };

        JButton submitButton = createStyledButton("Submit Request");
        JButton exitButton = createStyledButton("Exit");
        footerPanel.add(submitButton);
        footerPanel.add(exitButton);
        footerPanel.setOpaque(false);
        backgroundPanel.add(footerPanel, BorderLayout.SOUTH);

        // Action Listeners
        submitButton.addActionListener(e -> submitRequest());
        exitButton.addActionListener(e -> frame.dispose());

        frame.add(backgroundPanel);
        frame.setVisible(true);
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Times New Roman", Font.BOLD, 16));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(0, 153, 204));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setOpaque(true);
        button.setPreferredSize(new Dimension(180, 40));
        return button;
    }

    private void submitRequest() {
        String name = nameField.getText().trim();
        String cnic = cnicField.getText().trim();
        String contact = contactField.getText().trim();
        String address = addressField.getText().trim();
        int tankerSize = tankerSizeBox.getSelectedIndex() == 0 ? 1000 : 2000;
        String deliveryType = (String) deliveryTypeBox.getSelectedItem();

        if (name.isEmpty() || cnic.isEmpty() || contact.isEmpty() || address.isEmpty() || deliveryType == null) {
            JOptionPane.showMessageDialog(frame, "Please fill all the fields!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        WaterRequestScheduler scheduler = new WaterRequestScheduler();
        scheduler.loadRequestsFromFile();
        scheduler.addRequest(name, cnic, contact, address, tankerSize, deliveryType);
        JOptionPane.showMessageDialog(frame, "Your request has been submitted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Customer::new);
    }
}
