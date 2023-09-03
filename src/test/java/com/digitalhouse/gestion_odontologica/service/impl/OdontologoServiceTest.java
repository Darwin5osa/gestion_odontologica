package com.digitalhouse.gestion_odontologica.service.impl;

//@SpringBootTest
/*class OdontologoServiceTest {
    private OdontologoService service;

    @Test
    void guardarConH2() {
        service = new OdontologoService(odontologoDao);
        OdontologoDaoH2Impl dao = new OdontologoDaoH2Impl();
        try {
            dao.crearTablas();
        } catch (Exception e) {
            fail();
        }
        service.setOdontologoDao(dao);
        Odontologo odontologo = new Odontologo(22, "Jose", "Perez");

        boolean resultado = service.guardar(odontologo);

        assertTrue(resultado);
    }

    @Test
    void listarTodosConH2() {
        service = new OdontologoService(odontologoDao);
        OdontologoDaoH2Impl dao = new OdontologoDaoH2Impl();
        try {
            dao.crearTablas();
        } catch (Exception e) {
            fail();
        }
        service.setOdontologoDao(dao);
        List<Odontologo> esperado = generarListaOdontologos();
        for (Odontologo odontologo : esperado) {
            service.guardar(odontologo);
        }

        List<Odontologo> resultado = service.listarTodos();

        assertArrayEquals(esperado.toArray(), resultado.toArray());
    }

    private List<Odontologo> generarListaOdontologos() {
        List<Odontologo> odontologos = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            Odontologo odontologo = new Odontologo(i * 33576, "Juan", "Fernandez");
            odontologos.add(odontologo);
        }
        return odontologos;
    }
}*/