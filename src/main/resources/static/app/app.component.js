(function(app) {
    app.AppComponent = ng.core
        .Component({
            selector: 'game-component',
            template: '<game-form></game-form>',
            directives: [app.GameFormComponent]
        })
        .Class({
            constructor: function() {}
        });
})(window.app || (window.app = {}));
