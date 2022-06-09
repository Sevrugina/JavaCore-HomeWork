package org.example.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Temperature {

    @JsonProperty(value = "LocalObservationDateTime")
    private String date_1;

    @JsonProperty(value = "WeatherText")
    private String weatherText;

    @JsonProperty(value = "Date")
    private String date_5;

    @JsonProperty(value = "Metric")
    private Metric metric;

    @JsonProperty(value = "Minimum")
    private Metric minimum;

    @JsonProperty(value = "Maximum")
    private Metric maximum;
}
