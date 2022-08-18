//Funcion para eliminar un registro
const deleteRegister = async (id) => {
  let request = await fetch("http://localhost:8080/phones/" + id, {
    method: "DELETE",
  });
  let dataJson = await request.json();

  console.log("Register deleted");
  location.reload();
};
