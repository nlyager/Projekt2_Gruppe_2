document.addEventListener("click", (event) => {
    if (!(event.target instanceof Element)) {
        return;
    }

    const trigger = event.target.closest("[data-dialog-id]");
    if (trigger) {
        const dialog = document.getElementById(trigger.dataset.dialogId);
        if (dialog instanceof HTMLDialogElement) {
            dialog.showModal();
        }
        return;
    }

    const cancelButton = event.target.closest("[data-dialog-close]");
    if (cancelButton) {
        const dialog = cancelButton.closest("dialog");
        if (dialog instanceof HTMLDialogElement) {
            dialog.close();
        }
    }
});
