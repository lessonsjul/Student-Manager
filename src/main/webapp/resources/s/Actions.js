function progress()
    {
        document.studForm.action = "progress";
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

    function choiseSemestr(){
        document.semesterForm.action = "semesters";
        semesterForm.submit();
    }

    function addSemester()
    {
        document.semesterForm.action = "addSemester";
        semesterForm.submit()
    }

    function editSemester(){
        document.semesterForm.action = "editSemester";
        semesterForm.submit();
    }

    function deleteSemester(){
        document.semesterForm.action = "deleteSemester";
        semesterForm.submit();
    }
