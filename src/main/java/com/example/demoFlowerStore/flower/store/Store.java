package com.example.demoFlowerStore.flower.store;

import java.util.ArrayList;

public class Store {
    private ArrayList<FlowerBucket> buckets = new ArrayList<FlowerBucket>();

    public void addBucket(FlowerBucket bucket) {
        buckets.add(bucket);
    }

    public boolean search(FlowerBucket bucket) {
        for (int i = 0; i < buckets.size(); ++i) {
            Integer thisChamos = buckets.get(i).getChamomiles();
            Integer otherChamos = bucket.getChamomiles();
            Integer thisRoses = buckets.get(i).getRoses();
            Integer otherRoses = bucket.getRoses();
            Integer thisTuls = buckets.get(i).getTulips();
            Integer otherTuls = bucket.getTulips();
            if (thisChamos.equals(otherChamos) && thisRoses.equals(otherRoses)
                    && thisTuls.equals(otherTuls)) {
                buckets.remove(i);
                return true;
            }
        }
        return false;
    }
}
