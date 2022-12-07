package nl.abn.assignment.entities;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.HashSet;
import java.util.Set;

@Document(collection = "recipe")
@Accessors(chain = true)
@Data
@Builder
public class Recipe {
    @MongoId(FieldType.OBJECT_ID)
    private String id;

    @Indexed(unique = true)
    @Field
    private String name;

    private Integer servings;

    @Field(targetType = FieldType.STRING)
    private RecipeType recipeType;

    private Set<Instruction> instructions;

    private Set<Ingredients>  ingredients;


}
