 function redirect(){
            const XHR = new XMLHttpRequest();
            var uri = "http://localhost:8080/alumnos/"+document.getElementById('id-delete').value;

            var res = undefined;

            XHR.onreadystatechange = function() {
            if (XHR.readyState == XMLHttpRequest.DONE) {
            res = JSON.parse(XHR.response);
            }
            }
            XHR.open('GET', uri, false);
            XHR.send();

            document.getElementById('hidden-id').value=res.id;
            document.getElementById('label-name').innerHTML = res.nombre;
            document.getElementById('label-apellido').innerHTML= res.apellido;
            document.getElementById('label-ci').innerHTML = res.cedula;
            document.getElementById('label-edad').innerHTML = res.edad;
            document.getElementById('label-carrera').innerHTML = res.carrera.descripcion;
            };
function nico(){
            const XHR = new XMLHttpRequest();
            var uri = "http://localhost:8080/view/get_for_delete?id="+document.getElementById('hidden-id').value;
            XHR.open('GET', uri, false);
            XHR.send();
            setTimeout(function() { 
            window.location.href="./listar"
            }, 2000);
            }
function redirect(){
            const XHR = new XMLHttpRequest();
            var uri = "http://localhost:8080/alumnos/"+document.getElementById('id-delete').value;

            var res = undefined;

            XHR.onreadystatechange = function() {
            if (XHR.readyState == XMLHttpRequest.DONE) {
            res = JSON.parse(XHR.response);
            }
            }
            XHR.open('GET', uri, false);
            XHR.send();

            document.getElementById('hidden-id').value=res.id;
            document.getElementById('label-name').innerHTML = res.nombre;
            document.getElementById('label-apellido').innerHTML= res.apellido;
            document.getElementById('label-ci').innerHTML = res.cedula;
            document.getElementById('label-edad').innerHTML = res.edad;
            document.getElementById('label-carrera').innerHTML = res.carrera.descripcion;
            };
            function nico(){
            const XHR = new XMLHttpRequest();
            var uri = "http://localhost:8080/view/get_for_delete?id="+document.getElementById('hidden-id').value;
            XHR.open('GET', uri, false);
            XHR.send();
            setTimeout(function() { 
            window.location.href="./listar"
            }, 2000);
            }

