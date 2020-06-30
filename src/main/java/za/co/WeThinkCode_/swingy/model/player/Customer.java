package za.co.WeThinkCode_.swingy.model.player;

import lombok.*;

@Getter
@EqualsAndHashCode
@ToString
@Builder
public class Customer {
    @NonNull
    private long id;
    @NonNull
    private String name;

}
