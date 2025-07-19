package DSAProject;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class Admin {
    private JFrame frame;
    private JTable scheduleTable;
    private DefaultTableModel tableModel;
    private WaterRequestScheduler scheduler;

    public Admin() {
        scheduler = new WaterRequestScheduler();
        scheduler.loadRequestsFromFile();

        frame = new JFrame("Admin Portal - Water Tanker Scheduler");
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
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };

        // Header Panel
        JPanel headerPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setPaint(new GradientPaint(0, 0, new Color(0, 51, 102), getWidth(), 0, new Color(16, 177, 224)));
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        JLabel headerLabel = new JLabel("Admin Portal - Water Tanker Scheduler");
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setFont(new Font("Pacifico", Font.BOLD, 28));
        headerPanel.add(headerLabel);
        headerPanel.setOpaque(false); // Make header panel transparent
        backgroundPanel.add(headerPanel, BorderLayout.NORTH);

        // Table Panel
        tableModel = new DefaultTableModel(new String[]{"S.No.", "Name", "CNIC", "Address", "Contact", "Tanker Size", "Delivery Type", "Delivery Day", "Delivery Time"}, 0);
        scheduleTable = new JTable(tableModel);
        scheduleTable.setFont(new Font("Poppins", Font.PLAIN, 18));
        scheduleTable.setRowHeight(30);
        scheduleTable.getTableHeader().setFont(new Font("Poppins", Font.BOLD, 20));
        scheduleTable.getTableHeader().setBackground(new Color(13, 174, 221));
        scheduleTable.getTableHeader().setForeground(Color.WHITE);
        scheduleTable.getTableHeader().setReorderingAllowed(false);

// Adjust column sizes
        scheduleTable.getColumnModel().getColumn(0).setPreferredWidth(30); // S.No.
        scheduleTable.getColumnModel().getColumn(3).setPreferredWidth(200); // Address

// Center align S.No.
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        scheduleTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);


        JScrollPane tableScrollPane = new JScrollPane(scheduleTable);
        tableScrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        tableScrollPane.setOpaque(false); // Make the scroll pane transparent
        tableScrollPane.getViewport().setOpaque(false); // Make the viewport transparent
        backgroundPanel.add(tableScrollPane, BorderLayout.CENTER);

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

        JButton viewSchedulesButton = createStyledButton("View Schedules");
        JButton updateRequestButton = createStyledButton("Update Request");
        JButton deleteRequestButton = createStyledButton("Delete Request");
        JButton exitButton = createStyledButton("Exit");

        footerPanel.add(viewSchedulesButton);
        footerPanel.add(updateRequestButton);
        footerPanel.add(deleteRequestButton);
        footerPanel.add(exitButton);
        footerPanel.setOpaque(false); // Make footer panel transparent
        backgroundPanel.add(footerPanel, BorderLayout.SOUTH);

        // Action Listeners
        viewSchedulesButton.addActionListener(e -> loadSchedules());
        updateRequestButton.addActionListener(e -> updateRequest());
        deleteRequestButton.addActionListener(e -> deleteRequest());
        exitButton.addActionListener(e -> frame.dispose());

        frame.add(backgroundPanel);
        frame.setVisible(true);
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Poppins", Font.BOLD, 16));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(0, 153, 204)); // Blue theme for buttons
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setOpaque(true);
        button.setPreferredSize(new Dimension(180, 40));
        return button;
    }

    private void loadSchedules() {
        tableModel.setRowCount(0); // Clear the table
        List<WaterRequest> requests = scheduler.getAllRequests();
        int serialNumber = 1;
        for (WaterRequest request : requests) {
            tableModel.addRow(new Object[]{
                    serialNumber++,
                    request.customerName,
                    request.cnic,
                    request.address,
                    request.contact,
                    request.tankerSize + " Gallons",
                    request.deliveryType,
                    request.deliveryDay,
                    request.deliveryTime
            });
        }
    }

    private void updateRequest() {
        String cnic = JOptionPane.showInputDialog(frame, "Enter CNIC to update:", "Update Request", JOptionPane.PLAIN_MESSAGE);
        if (cnic == null || cnic.trim().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "CNIC cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String deliveryDay = (String) JOptionPane.showInputDialog(frame, "Select Delivery Day:", "Delivery Day",
                JOptionPane.QUESTION_MESSAGE, null, new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"}, "Monday");
        if (deliveryDay == null) return;

        String deliveryTime = (String) JOptionPane.showInputDialog(frame, "Select Delivery Time:", "Delivery Time",
                JOptionPane.QUESTION_MESSAGE, null, new String[]{"10:00 AM", "12:00 PM", "2:00 PM", "4:00 PM", "6:00 PM"}, "10:00 AM");
        if (deliveryTime == null) return;

        boolean updated = scheduler.updateRequest(cnic, deliveryDay, deliveryTime);
        if (updated) {
            JOptionPane.showMessageDialog(frame, "Request updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            loadSchedules();
        } else {
            JOptionPane.showMessageDialog(frame, "No request found with the given CNIC.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteRequest() {
        String cnic = JOptionPane.showInputDialog(frame, "Enter CNIC to delete:", "Delete Request", JOptionPane.PLAIN_MESSAGE);
        if (cnic == null || cnic.trim().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "CNIC cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean deleted = scheduler.deleteRequest(cnic);
        if (deleted) {
            JOptionPane.showMessageDialog(frame, "Request deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            loadSchedules();
        } else {
            JOptionPane.showMessageDialog(frame, "No request found with the given CNIC.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Admin::new);
    }
}

