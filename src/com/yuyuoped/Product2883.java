package com.yuyuoped;

import java.util.Map;
import java.util.Set;

public class Product2883 {
    Map<String, Integer> storage;
    Map<String, Integer> sale;

    // write your code here

    public Product2883(Map<String, Integer> storage, Map<String, Integer> sale) {
        this.storage = storage;
        this.sale = sale;
    }

    public boolean onSale(String key, int n) {
        if (storage.containsKey(key) && storage.get(key) > 0 && n != 0) {
            Integer count = storage.get(key);
            if (n > count) n = count;
            if (sale.containsKey(key)) {
                sale.put(key, sale.get(key) + n);
            } else {
                sale.put(key, n);
            }
            storage.put(key, storage.get(key) - n);
            return true;
        }
        return false;
    }

    public int sellOut(String key, int n) {
        if (sale.containsKey(key)) {
            Integer count = sale.get(key);
            if (count > n) {
                sale.put(key, count - n);
                return n;
            } else {
                sale.remove(key);
                return count;
            }
        } else {
            return 0;
        }
    }

    public String readStorage() {
        return formatMap(storage);
    }

    public String readSale() {
        return formatMap(sale);
    }

    private String formatMap(Map<String, Integer> map) {
        StringBuilder sb = new StringBuilder();
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        int size = entries.size();
        sb.append("{");
        int i = 0;
        for (Map.Entry<String, Integer> entry : entries) {
            sb.append(entry.getKey()).append("=").append(entry.getValue());
            if (++i < size) {
                sb.append(",");
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
/*
Storage: {Apple=90, TV=20, Phone=30, Cake=60, Note=50, Meat=80, Milk=70, Beer=40}
Sale: {Apple=50, Meat=60}
On sale: TV : 8, true
On sale: Apple : 29, true
On sale: Cake : 23, true
On sale: Note : 18, true
On sale: Note : 12, true
On sale: Apple : 18, true
On sale: Cake : 27, true
On sale: TV : 17, true
On sale: Apple : 21, true
On sale: TV : 22, true
Sell out: Beer : 0
Sell out: Apple : 98
Sell out: Apple : 20
Sell out: Note : 30
Sell out: Book : 0
Sell out: Milk : 0
Sell out: Apple : 0
Sell out: Flower : 0
Sell out: Tea : 0
Sell out: Apple : 0
Sell out: Note : 0
Sell out: Apple : 0
Sell out: Note : 0
Sell out: Flower : 0
Storage: {Apple=22, TV=0, Phone=30, Cake=10, Note=20, Meat=80, Milk=70, Beer=40}
Sale: {TV=20, Cake=50, Meat=60}

期望答案
Storage: {Apple=90, TV=20, Phone=30, Cake=60, Note=50, Meat=80, Milk=70, Beer=40}
Sale: {Apple=50, Meat=60}
On sale: TV : 8, true
On sale: Apple : 29, true
On sale: Cake : 23, true
On sale: Note : 18, true
On sale: Note : 12, true
On sale: Apple : 18, true
On sale: Cake : 27, true
On sale: TV : 17, true
On sale: Apple : 21, true
On sale: TV : 22, false
Sell out: Beer : 0
Sell out: Apple : 98
Sell out: Apple : 20
Sell out: Note : 30
Sell out: Book : 0
Sell out: Milk : 0
Sell out: Apple : 0
Sell out: Flower : 0
Sell out: Tea : 0
Sell out: Apple : 0
Sell out: Note : 0
Sell out: Apple : 0
Sell out: Note : 0
Sell out: Flower : 0
Storage: {Apple=22, TV=0, Phone=30, Cake=10, Note=20, Meat=80, Milk=70, Beer=40}
Sale: {TV=20, Cake=50, Meat=60}
 */