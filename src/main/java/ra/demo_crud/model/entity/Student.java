package ra.demo_crud.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor // constructor không tham số
@AllArgsConstructor // constructor full tham số
@Data // getter, setter
public class Student {
    private  Long id;
    private  String name;
    private  Integer age;
    private  Boolean sex;
}
