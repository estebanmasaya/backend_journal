package com.kth.estmm.backend_journal.BO.Services;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class PatientFromJson {
    @JsonProperty("entry")
    private Entry[] entry;

    public Entry[] getEntry() {
        return entry;
    }

    public static class Entry {
        @JsonProperty("resource")
        private Map<String, Object> resource;

        public Map<String, Object> getResource() {
            return resource;
        }
    }
}
