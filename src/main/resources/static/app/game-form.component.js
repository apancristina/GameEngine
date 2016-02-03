(function(app) {
    app.GameFormComponent = ng.core
        .Component({
            selector: 'game-form',
            templateUrl: 'app/game-form.component.html'
        })
        .Class({
            constructor: function () {
                this.player = ['Sechel', 'Apan'];
                this.model = new app.Game(18, 'The musketeers', this.player[0]);
                this.submitted = false;
            },
            onSubmit: function () {
                this.submitted = true;
            },
            // TODO: Remove this when we're done
            diagnostic: function () {
                return JSON.stringify(this.model);
            }
        });
})