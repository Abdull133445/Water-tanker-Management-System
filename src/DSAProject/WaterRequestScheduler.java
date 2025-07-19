package DSAProject;

import java.io.*;
import java.util.*;

class WaterRequest implements Comparable<WaterRequest> {
    String customerName;
    String cnic;
    String contact;
    String address;
    int tankerSize;
    String deliveryType;
    String deliveryDay;
    String deliveryTime;

    public WaterRequest(String customerName, String cnic, String contact, String address, int tankerSize, String deliveryType, String deliveryDay, String deliveryTime) {
        this.customerName = customerName;
        this.cnic = cnic;
        this.contact = contact;
        this.address = address;
        this.tankerSize = tankerSize;
        this.deliveryType = deliveryType;
        this.deliveryDay = deliveryDay;
        this.deliveryTime = deliveryTime;
    }

    @Override
    public int compareTo(WaterRequest other) {
        // Prioritize Emergency over Normal deliveries
        if (this.deliveryType.equals("Emergency") && other.deliveryType.equals("Normal")) {
            return -1;
        } else if (this.deliveryType.equals("Normal") && other.deliveryType.equals("Emergency")) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Name: " + customerName + ", CNIC: " + cnic + ", Contact: " + contact +
                ", Address: " + address + ", Tanker Size: " + tankerSize + ", Delivery Type: " + deliveryType +
                ", Delivery Day: " + deliveryDay + ", Delivery Time: " + deliveryTime;
    }
}

public class WaterRequestScheduler {
    private static final String DATABASE = "tankers.txt";
    private Map<String, WaterRequest> requestMap = new HashMap<>();
    private PriorityQueue<WaterRequest> requestQueue = new PriorityQueue<>();

    public void addRequest(String name, String cnic, String contact, String address, int tankerSize, String deliveryType) {
        WaterRequest request = new WaterRequest(name, cnic, contact, address, tankerSize, deliveryType, "Not Assigned", "Not Assigned");
        requestMap.put(cnic, request);
        requestQueue.add(request);
        saveRequestToFile(request);
    }

    public boolean updateRequest(String cnic, String deliveryDay, String deliveryTime) {
        WaterRequest request = requestMap.get(cnic);
        if (request != null) {
            request.deliveryDay = deliveryDay;
            request.deliveryTime = deliveryTime;
            saveAllRequestsToFile();
            return true;
        }
        return false;
    }

    public boolean deleteRequest(String cnic) {
        WaterRequest request = requestMap.remove(cnic);
        if (request != null) {
            requestQueue.remove(request);
            saveAllRequestsToFile();
            return true;
        }
        return false;
    }

    private void saveRequestToFile(WaterRequest request) {
        try (FileWriter fw = new FileWriter(DATABASE, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(request.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveAllRequestsToFile() {
        try (FileWriter fw = new FileWriter(DATABASE, false);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            for (WaterRequest request : requestQueue) {
                out.println(request.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<WaterRequest> getAllRequests() {
        return new ArrayList<>(requestQueue);
    }

    public void loadRequestsFromFile() {
        requestMap.clear();
        requestQueue.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(DATABASE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] details = line.split(", ");
                String name = getValue(details, "Name");
                String cnic = getValue(details, "CNIC");
                String contact = getValue(details, "Contact");
                String address = getValue(details, "Address");
                int tankerSize = parseSafe(getValue(details, "Tanker Size"));
                String deliveryType = getValue(details, "Delivery Type");
                String deliveryDay = getValue(details, "Delivery Day");
                String deliveryTime = getValue(details, "Delivery Time");

                WaterRequest request = new WaterRequest(name, cnic, contact, address, tankerSize, deliveryType, deliveryDay, deliveryTime);
                requestMap.put(cnic, request);
                requestQueue.add(request);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int parseSafe(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return 0; // Default for invalid entries
        }
    }

    private String getValue(String[] details, String key) {
        for (String detail : details) {
            if (detail.startsWith(key)) {
                return detail.split(": ")[1];
            }
        }
        return "N/A";
    }
}

