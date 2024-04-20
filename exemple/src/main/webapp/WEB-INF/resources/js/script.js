// Script JavaScript pour la confirmation de suppression d'un employé
window.onload = function() {
    const deleteLinks = document.querySelectorAll('.delete-link');

    deleteLinks.forEach(link => {
        link.addEventListener('click', function(event) {
            const confirmation = confirm('Are you sure you want to delete this employee?');
            if (!confirmation) {
                event.preventDefault(); // Annuler le comportement par défaut du lien si la suppression est annulée
            }
        });
    });
};
