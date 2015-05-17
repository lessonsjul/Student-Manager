    function progress()
    {
        document.studForm.action = "progress";
        document.studForm.createAttribute("idStud").value = 1;
        studForm.submit();
    }

    function addStudent(){
        document.studForm.action = "addStudent";
        studForm.submit();
    }

    function editStudent(){
        document.studForm.action = "editStudent";
        studForm.submit();
    }

    function deleteStudent(){
        document.studForm.action = "deleteStudent";
        studForm.submit();
    }

    function addDiscipline()
    {
        document.disciplForm.action = "addDiscipline";
        disciplForm.submit()
    }

    function editDiscipline(){
        document.disciplForm.action = "editDiscipline";
        disciplForm.submit();
    }

    function deleteDiscipline(){
        document.disciplForm.action = "deleteDiscipline";
        disciplForm.submit();
    }

    function changeSemestr(id){
        document.semesterForm.idSem.value = id;
    }

    function addSemester()
    {
        document.semesterButton.action = "addSemester";
        semesterForm.submit()
    }

    function editSemester(){
        document.semesterButton.action = "editSemester";
        semesterForm.submit();
    }

    function deleteSemester(){
        document.semesterButton.action = "deleteSemester";
        semesterForm.submit();
    }