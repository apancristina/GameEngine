(function(app) {
    app.Game = Game;
    function Game(id, team, player) {
        this.id = id;
        this.team = team;
        this.player = player;
    }
})(window.app || (window.app = {}));
