package models.exchange;

import com.fasterxml.jackson.annotation.JsonProperty;

    public class Exchange {
        @JsonProperty("r030")
        public int peremennaya;
        public String txt;

        public double getRate() {
            return rate;
        }

        private double rate;
        public String cc;
        public String exchangedate;

    }


