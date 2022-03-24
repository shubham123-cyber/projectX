package com.projectX.projectX;


import com.projectX.projectX.model.Employee;
import com.projectX.projectX.repository.Sqlrepo;
import com.projectX.projectX.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeTest {
    @Autowired
    @InjectMocks
    private EmployeeService employeeService;
    @MockBean
    private Sqlrepo sqlrepo;


    @Test
    public void getEmp() {
        when(sqlrepo.findAll()).thenReturn(Stream.of(new Employee(1,"Neymar","983939842"),new Employee(2,"Meradona","65473663764")).collect(Collectors.toList()));
        assertEquals(2,employeeService.getAllEmp().size());
    }

    @Test
    public void saveEmp() throws Exception {
        Employee empl=new Employee(4,"Levandowski","76345743544");
        when(sqlrepo.save(empl)).thenReturn(empl);
        assertEquals(empl, employeeService.insertEmployee(empl));

    }

    @Test
    public void checkUpdate() {
        Employee employee=new Employee(7,"Ramos","8346374823");
        Employee emploY=new Employee(7,"Chhetri","8766344287");
        Optional<Employee> optional = Optional.of(employee);
        when(employeeService.getEmployeeById(Mockito.anyInt())).thenReturn(optional);
        when(sqlrepo.save(Mockito.any())).thenReturn(emploY);
        assertNotNull(employeeService.updateById(employee));

    }

    @Test
    public void checkUpdate_When_return_is_null() {
        Employee employee=new Employee(7,"Ramos","8346374823");
        Employee emploY=new Employee(7,"Chhetri","8766344287");
        Optional<Employee> optional = Optional.empty();
        when(employeeService.getEmployeeById(Mockito.anyInt())).thenReturn(optional);
        when(sqlrepo.save(Mockito.any())).thenReturn(emploY);
        assertNull(employeeService.updateById(employee));

    }

    @Test
    public void deleteEMp_when_not_null()
    {
        Employee mpp=new Employee(5,"Andres", "6447658374");
        assertNotNull(employeeService.delById(Mockito.anyInt()));
    }

    @Test
    public void deleteEMp_when_null() {
        Employee mpp=new Employee(5,"Guardiola", "6447658379");
        assertNull(employeeService.delById(null));
    }




//    private MockMvc mockMvc;
//    ObjectMapper objectMapper = new ObjectMapper();
//    ObjectWriter objectWriter = objectMapper.writer();
//
//    @Mock
//    private Sqlrepo Sqlrepo;
//    @InjectMocks
//    private Restcontroller restcontroller;
//    Employee emp1= new Employee(2,"Messi","6200474828");
//    Employee emp2=new Employee(3,"Ronaldo","4643947465");
//    Employee emp3=new Employee(5,"Xavi","4467647477");
//
////    @Before
////    public void setUp() {
////        MockitoAnnotations.
//    @Rule
//    public MockitoRule mockitoRule = MockitoJUnit.rule();
//
//
//    @Test
//    public void Addnewuser() throws Exception {
//        Employee empp = Employee.builder()
//                .id(5)
//                .name("Xavi")
//                .phone("6544747656")
//                .build();
//        Mockito.when(Sqlrepo.save(empp)).thenReturn(empp);
//        String value=objectMapper.writeValueAsString(empp);
//        MockHttpServletRequestBuilder mockHttpServletRequestBuilder= MockMvcRequestBuilders.post("/add")
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON)
//                .content(value);
//        mockMvc.perform(mockHttpServletRequestBuilder)
//                .andExpect(status().isOk())
//                .andExpect((ResultMatcher) jsonPath("$.name","Xavi"))
//                .andExpect((ResultMatcher) jsonPath("$.phone","6544747656"));
//    }
}
